package lt.vu.persistence;

import lt.vu.entities.Customer;
import lt.vu.entities.ShoppingCart;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ShoppingCartsDAO {

    @Inject
    private EntityManager em;

    public List<ShoppingCart> loadAll() {
        return em.createNamedQuery("ShoppingCarts.findAll", ShoppingCart.class).getResultList();
    }

    public ShoppingCart findOne(int id) {
        return em.find(ShoppingCart.class, id);
    }

    public List<ShoppingCart> findByCustomer(Customer customer) {
        return em.createNamedQuery("ShoppingCarts.findByCustomer", ShoppingCart.class).setParameter("customer", customer).getResultList();
    }

    public void persist(ShoppingCart shoppingCart) {
        this.em.persist(shoppingCart);
    }
}
