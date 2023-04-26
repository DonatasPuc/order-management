package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Shoppingcart;
import org.mybatis.cdi.Mapper;

@Mapper
public interface ShoppingcartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOPPINGCART
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOPPINGCART
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    int insert(Shoppingcart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOPPINGCART
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    Shoppingcart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOPPINGCART
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    List<Shoppingcart> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.SHOPPINGCART
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    int updateByPrimaryKey(Shoppingcart record);
}