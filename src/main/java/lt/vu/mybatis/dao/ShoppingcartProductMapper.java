package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Product;

import javax.enterprise.inject.Model;
import java.util.List;

@Model
public interface ShoppingcartProductMapper {
    int deleteProduct(Integer shoppingCartId, Integer productId);
    int addProduct(Integer shoppingCartId, Integer productId);
    List<Product> getProducts(Integer shoppingCartId);
}
