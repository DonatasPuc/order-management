package lt.vu.mybatis.model;

import java.util.Date;

public class Shoppingcart {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPPINGCART.ID
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPPINGCART.CREATEDATE
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    private Date createdate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPPINGCART.NUMBER
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    private Integer number;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SHOPPINGCART.CUSTOMER_ID
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    private Integer customerId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPPINGCART.ID
     *
     * @return the value of PUBLIC.SHOPPINGCART.ID
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPPINGCART.ID
     *
     * @param id the value for PUBLIC.SHOPPINGCART.ID
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPPINGCART.CREATEDATE
     *
     * @return the value of PUBLIC.SHOPPINGCART.CREATEDATE
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPPINGCART.CREATEDATE
     *
     * @param createdate the value for PUBLIC.SHOPPINGCART.CREATEDATE
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPPINGCART.NUMBER
     *
     * @return the value of PUBLIC.SHOPPINGCART.NUMBER
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPPINGCART.NUMBER
     *
     * @param number the value for PUBLIC.SHOPPINGCART.NUMBER
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SHOPPINGCART.CUSTOMER_ID
     *
     * @return the value of PUBLIC.SHOPPINGCART.CUSTOMER_ID
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SHOPPINGCART.CUSTOMER_ID
     *
     * @param customerId the value for PUBLIC.SHOPPINGCART.CUSTOMER_ID
     *
     * @mbg.generated Wed Apr 26 06:03:46 EEST 2023
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}