package lt.vu.usecases;

import lt.vu.entities.Product;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.services.ProductDiscountGenerator;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GenerateProductDiscount implements Serializable {

    @Inject
    ProductDiscountGenerator productDiscountGenerator;

    private CompletableFuture<Integer> productDiscountGenerationTask = null;

    @LoggedInvocation
    public String generateProductDiscount(Product product) {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        productDiscountGenerationTask = CompletableFuture.supplyAsync(() -> productDiscountGenerator.calculateProductDiscount(product));

        return  "/productdetails.xhtml?faces-redirect=true&productId=" + requestParameters.get("productId");
    }

    public boolean isDiscountGenerationRunning() {
        return productDiscountGenerationTask != null && !productDiscountGenerationTask.isDone();
    }

    public String getDiscountGenerationStatus() throws ExecutionException, InterruptedException {
        if (productDiscountGenerationTask == null) {
            return null;
        } else if (isDiscountGenerationRunning()) {
            return "Product discount generation in progress";
        }
        return "Suggested product discount: " + productDiscountGenerationTask.get();
    }
}
