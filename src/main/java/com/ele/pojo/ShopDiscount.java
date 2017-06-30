package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
public class ShopDiscount {
    private Integer id;
    private String shopDiscountDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopDiscountDesc() {
        return shopDiscountDesc;
    }

    public void setShopDiscountDesc(String shopDiscountDesc) {
        this.shopDiscountDesc = shopDiscountDesc;
    }

    @Override
    public String toString() {
        return "ShopDiscount{" +
                "id=" + id +
                ", shopDiscountDesc='" + shopDiscountDesc + '\'' +
                '}';
    }
}
