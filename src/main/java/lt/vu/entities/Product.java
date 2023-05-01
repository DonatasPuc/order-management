package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "Products.findAll", query = "select p from Product as p")
})
public class Product implements Serializable {

    public Product() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();
}
