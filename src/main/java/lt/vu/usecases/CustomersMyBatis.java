package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.CustomerMapper;
import lt.vu.mybatis.model.Customer;
import org.mybatis.cdi.Transactional;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.List;

@Model
public class CustomersMyBatis {

    @Inject
    private CustomerMapper customerMapper;

    @Getter
    private List<Customer> allCustomers;

    @Getter @Setter
    private Customer customerToCreate = new Customer();

    @PostConstruct
    private void init() { allCustomers = customerMapper.selectAll(); }

    @Transactional
    public String createCustomer() {
        customerMapper.insert(customerToCreate);
        return "/index?faces-redirect=true";
    }
}
