package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.ShoppingcartProductMapper;
import lt.vu.mybatis.model.Product;
import lt.vu.persistence.ProductsDAO;
import org.mybatis.cdi.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@Model
public class ShoppingCartProductsMyBatis {

    @Inject
    private ShoppingcartProductMapper shoppingcartProductMapper;

    @Getter @Setter
    private List<Product> products;

    @Getter @Setter
    private List<Integer> productIds;

    @Getter
    private Integer shoppingCartId;

    @Getter
    private Integer customerId;


    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        shoppingCartId = Integer.parseInt(requestParameters.get("shoppingCartId"));
        customerId = Integer.parseInt(requestParameters.get("customerId"));

        products = shoppingcartProductMapper.getProducts(shoppingCartId);
        productIds = products.stream().map(Product::getId).collect(Collectors.toList());
    }

    @Transactional
    public String updateProducts() {
        List<Integer> oldProductsIds = shoppingcartProductMapper.getProducts(shoppingCartId).stream()
                .map(Product::getId).collect(Collectors.toList());

        List<Integer> idsToRemove = new ArrayList<>();
        List<Integer> idsToAdd= new ArrayList<>();

        for (Integer p : productIds) if (!oldProductsIds.contains(p)) idsToAdd.add(p);
        for (Integer p : oldProductsIds) if (!productIds.contains(p)) idsToRemove.add(p);

        idsToAdd.forEach(id -> shoppingcartProductMapper.addProduct(shoppingCartId, id));
        idsToRemove.forEach(id -> shoppingcartProductMapper.deleteProduct(shoppingCartId, id));

        return "shoppingcart.xhtml?faces-redirect=true&shoppingCartId=" + shoppingCartId + "&customerId=" + customerId;
    }
}
