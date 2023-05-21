package lt.vu.entities;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
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
    private Integer discount = 0;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @ManyToMany(mappedBy = "products")
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();
}
