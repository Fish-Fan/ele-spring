package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
public class ShopManager {
    private Integer shopId;
    private String phoneNum;
    private String password;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ShopManager{" +
                "shopId=" + shopId +
                ", phoneNum='" + phoneNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
