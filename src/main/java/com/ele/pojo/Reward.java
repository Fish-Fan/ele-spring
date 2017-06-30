package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class Reward {
    private Integer id;
    private Integer shopFoodId;
    private Integer shopId;
    private Integer userId;
    private String rewardMsg;
    private Boolean cool;
    private Boolean good;
    private Boolean bad;
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopFoodId() {
        return shopFoodId;
    }

    public void setShopFoodId(Integer shopFoodId) {
        this.shopFoodId = shopFoodId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRewardMsg() {
        return rewardMsg;
    }

    public void setRewardMsg(String rewardMsg) {
        this.rewardMsg = rewardMsg;
    }

    public Boolean getCool() {
        return cool;
    }

    public void setCool(Boolean cool) {
        this.cool = cool;
    }

    public Boolean getGood() {
        return good;
    }

    public void setGood(Boolean good) {
        this.good = good;
    }

    public Boolean getBad() {
        return bad;
    }

    public void setBad(Boolean bad) {
        this.bad = bad;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "Reward{" +
                "id=" + id +
                ", shopFoodId=" + shopFoodId +
                ", shopId=" + shopId +
                ", userId=" + userId +
                ", rewardMsg='" + rewardMsg + '\'' +
                ", cool=" + cool +
                ", good=" + good +
                ", bad=" + bad +
                ", orderId=" + orderId +
                '}';
    }
}
