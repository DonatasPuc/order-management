package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Customer;
import lt.vu.persistence.CustomersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class Customers {

    @Inject
    private CustomersDAO customersDAO;

    @Getter
    private List<Customer> allCustomers;

    @PostConstruct
    public void init() {
        this.allCustomers = customersDAO.loadAll();
    }
}
