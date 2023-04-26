package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.CustomerMapper;
import lt.vu.mybatis.model.Customer;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Map;

@Model
public class CustomerDetailsMyBatis {

    @Inject
    private CustomerMapper customerMapper;

    @Getter @Setter
    private Customer customer;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer customerId = Integer.parseInt(requestParameters.get("customerId"));
        this.customer = customerMapper.selectByPrimaryKey(customerId);
    }
}
