package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
public class ShopDiscountDesc {
    private Integer id;
    private Integer shopId;
    private Integer shopDiscountId;
    private String shopDiscountDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getShopDiscountId() {
        return shopDiscountId;
    }

    public void setShopDiscountId(Integer shopDiscountId) {
        this.shopDiscountId = shopDiscountId;
    }

    public String getShopDiscountDesc() {
        return shopDiscountDesc;
    }

    public void setShopDiscountDesc(String shopDiscountDesc) {
        this.shopDiscountDesc = shopDiscountDesc;
    }

    @Override
    public String toString() {
        return "ShopDiscountDesc{" +
                "id=" + id +
                ", shopId=" + shopId +
                ", shopDiscountId=" + shopDiscountId +
                ", shopDiscountDesc='" + shopDiscountDesc + '\'' +
                '}';
    }
}
