package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Customer;
import lt.vu.entities.Product;
import lt.vu.entities.ShoppingCart;
import lt.vu.mybatis.dao.ShoppingcartProductMapper;
import lt.vu.persistence.CustomersDAO;
import lt.vu.persistence.ProductsDAO;
import lt.vu.persistence.ShoppingCartsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Model
public class ShoppingCarts {

    @Inject
    private ShoppingcartProductMapper shoppingcartProductMapper;

    @Inject
    private ShoppingCartsDAO shoppingCartsDAO;

    @Inject
    private CustomersDAO customersDAO;

    @Inject
    private ProductsDAO productsDAO;

    @Getter
    @Setter
    private Customer customer;

    @Getter
    @Setter
    private ShoppingCart shoppingCartToCreate = new ShoppingCart();

    @Getter
    @Setter
    private List<ShoppingCart> customerShoppingCarts;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int customerId = Integer.parseInt(requestParameters.get("customerId"));

        customer = customersDAO.findOne(customerId);
        customerShoppingCarts = shoppingCartsDAO.findByCustomer(customer);
    }

    @Transactional
    public String createShoppingCart() {
        shoppingCartToCreate.setCustomer(customer);
        shoppingCartToCreate.setCreateDate(new Date());
        shoppingCartToCreate.setNumber(customerShoppingCartNumber());

        shoppingCartsDAO.persist(shoppingCartToCreate);
        return "/customers.xhtml?faces-redirect=true&customerId=" + customer.getId();
    }

    @Transactional
    public String removeShoppingCart(int shoppingCartId) {
        shoppingCartsDAO.remove(shoppingCartsDAO.findOne(shoppingCartId));
        return "/customers.xhtml?faces-redirect=true&customerId=" + customer.getId();
    }

    public List<Product> getShoppingCartProducts(int shoppingCartId) {
        return productsDAO.loadAll().stream()
                .filter(product -> product.getShoppingCarts().contains(shoppingCartsDAO.findOne(shoppingCartId)))
                .collect(Collectors.toList());
    }

    private int customerShoppingCartNumber() {
        return customerShoppingCarts
                .stream()
                .map(ShoppingCart::getNumber)
                .max(Comparator.naturalOrder())
                .orElse(0) + 1;
    }

    public int customerShoppingCartCount() {
        return customerShoppingCarts.size();
    }

    public int shoppingCartProductCount(Integer shoppingCartId) {
        return shoppingcartProductMapper.getProductCount(shoppingCartId);
    }
}
