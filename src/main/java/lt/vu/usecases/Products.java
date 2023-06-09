package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Product;
import lt.vu.persistence.ProductsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Products {

    @Inject
    private ProductsDAO productsDAO;

    @Getter
    @Setter
    private Product productToCreate = new Product();

    @Getter
    private List<Product> allProducts;

    @PostConstruct
    public void init(){
        loadProducts();
    }

    public void loadProducts() {
        this.allProducts = productsDAO.loadAll();
    }

    @Transactional
    public String createProduct(){
        this.productsDAO.persist(productToCreate);

        return "/products?faces-redirect=true";
    }
}
