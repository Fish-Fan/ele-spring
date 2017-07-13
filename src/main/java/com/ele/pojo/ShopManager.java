package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
public class ShopManager {
    private Integer shopId;
    private String phoneNum;
    private String passWord;

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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "ShopManager{" +
                "shopId=" + shopId +
                ", phoneNum='" + phoneNum + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
