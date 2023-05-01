package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Customer;
import lt.vu.entities.ShoppingCart;
import lt.vu.persistence.CustomersDAO;
import lt.vu.persistence.ShoppingCartsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

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
    private List<ShoppingCart> customerShoppingCarts;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int customerId = Integer.parseInt(requestParameters.get("customerId"));

        customer = customersDAO.findOne(customerId);
        customerShoppingCarts = shoppingCartsDAO.findByCustomer(customer);
    }

    @Transactional
    public String createShoppingCart(){
        this.shoppingCartToCreate.setCustomer(customer);
        this.shoppingCartsDAO.persist(shoppingCartToCreate);
        return "/customers.xhtml?faces-redirect=true&customerId=" + customer.getId();
    }
}
