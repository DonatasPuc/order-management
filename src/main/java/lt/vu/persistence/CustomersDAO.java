package lt.vu.persistence;

import entities.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CustomersDAO {

    @Inject
    private  EntityManager em;

    public List<Customer> loadAll() {
        return em.createNamedQuery("Customers.findAll", Customer.class).getResultList();
    }

    public Customer findOne(int id) {
        return em.find(Customer.class, id);
    }

    public void persist(Customer customer){
        this.em.persist(customer);
    }
}
