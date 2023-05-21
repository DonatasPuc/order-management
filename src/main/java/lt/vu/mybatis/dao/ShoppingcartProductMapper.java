package lt.vu.mybatis.dao;

import lt.vu.mybatis.model.Product;
import org.apache.ibatis.annotations.Param;
import org.mybatis.cdi.Mapper;

import java.util.List;

@Mapper
public interface ShoppingcartProductMapper {
    int deleteProduct(@Param("shoppingCartId") Integer shoppingCartId, @Param("productId") Integer productId);
    int addProduct(@Param("shoppingCartId") Integer shoppingCartId, @Param("productId") Integer productId);
    List<Product> getProducts(Integer shoppingCartId);

    int getProductCount(Integer shoppingCartId);
}
