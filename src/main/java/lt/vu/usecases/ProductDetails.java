package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Product;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.ProductsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class ProductDetails implements Serializable {

    private Product product;
    @Inject
    private ProductsDAO productsDAO;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        int productId = Integer.parseInt(requestParameters.get("productId"));
        this.product = productsDAO.findOne(productId);
    }

    @Transactional
    @LoggedInvocation
    public String updateProductDiscount() {
        try{
            productsDAO.update(this.product);
        } catch (OptimisticLockException e) {
            return "/productdetails.xhtml?faces-redirect=true&productId=" + this.product.getId() + "&error=optimistic-lock-exception";
        }
        return "productdetails.xhtml?productId=" + this.product.getId() + "&faces-redirect=true";
    }
}
