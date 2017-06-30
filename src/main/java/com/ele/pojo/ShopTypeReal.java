package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class ShopTypeReal {
    private Integer shopTypeId;
    private Integer shopId;

    public Integer getShopTypeId() {
        return shopTypeId;
    }

    public void setShopTypeId(Integer shopTypeId) {
        this.shopTypeId = shopTypeId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopTypeReal{" +
                "shopTypeId=" + shopTypeId +
                ", shopId=" + shopId +
                '}';
    }
}
