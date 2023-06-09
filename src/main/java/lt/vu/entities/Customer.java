package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Customers.findAll", query = "select c from Customer as c")
})
public class Customer implements Serializable {

    public Customer() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max=50)
    private String name;
    private String address;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<ShoppingCart> shoppingCarts = new ArrayList<>();
}
