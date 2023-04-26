package lt.vu.persistence;

import entities.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProductsDAO {

    @Inject
    private EntityManager em;

    public List<Product> loadAll() {
        return em.createNamedQuery("Products.findAll", Product.class).getResultList();
    }

    public Product findOne(int id) {
        return em.find(Product.class, id);
    }

    public void persist(Product product){
        this.em.persist(product);
    }
}
