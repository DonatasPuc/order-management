package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Customer;
import lt.vu.entities.ShoppingCart;
import lt.vu.persistence.CustomersDAO;
import lt.vu.persistence.ShoppingCartsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ShoppingCarts {

    @Inject
    private ShoppingCartsDAO shoppingCartsDAO;

    @Inject
    private CustomersDAO customersDAO;

    @Getter @Setter
    private Customer customer;

    @Getter @Setter
    private ShoppingCart shoppingCartToCreate = new ShoppingCart();

    @Getter @Setter
    private List<ShoppingCart> allShoppingCarts;

    @PostConstruct
    public void init(){
        loadShoppingCarts();
    }

    public void loadShoppingCarts() {
        this.allShoppingCarts = shoppingCartsDAO.loadAll();
    }

    @Transactional
    public String createShoppingCart(){
        this.shoppingCartToCreate.setCustomer(customer);
        this.shoppingCartsDAO.persist(shoppingCartToCreate);
        return "/customers?faces-redirect=true";
    }
}
