package lt.vu.usecases;

import lombok.Getter;
import lt.vu.mybatis.dao.ShoppingcartProductMapper;
import lt.vu.mybatis.model.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
public class ShoppingCartProductsMyBatis {

    @Inject
    private ShoppingcartProductMapper shoppingcartProductMapper;

    @Getter
    private List<Product> products;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer shoppingCartId = Integer.parseInt(requestParameters.get("shoppingCartId"));

        products = shoppingcartProductMapper.getProducts(shoppingCartId);
    }
}
