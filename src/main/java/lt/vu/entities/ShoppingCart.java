package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "SHOPPINGCART")
@NamedQueries({
        @NamedQuery(name = "ShoppingCarts.findAll", query = "select c from ShoppingCart as c")
})
public class ShoppingCart implements Serializable {

    public ShoppingCart() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;
    private Date createDate;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;
}
