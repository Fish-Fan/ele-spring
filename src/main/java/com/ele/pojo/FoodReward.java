package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class FoodReward {
    private Integer id;
    private Integer shopFoodId;
    private Integer shopId;
    private Integer userId;
    private String username;
    private String avatar;
    private String rewardMsg;
    private Integer orderId;
    private String rewardTime;
    private Integer rewardType;
    private Integer grade;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getRewardMsg() {
        return rewardMsg;
    }

    public void setRewardMsg(String rewardMsg) {
        this.rewardMsg = rewardMsg;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(String rewardTime) {
        this.rewardTime = rewardTime;
    }

    public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "FoodReward{" +
                "id=" + id +
                ", shopFoodId=" + shopFoodId +
                ", shopId=" + shopId +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", rewardMsg='" + rewardMsg + '\'' +
                ", orderId=" + orderId +
                ", rewardTime='" + rewardTime + '\'' +
                ", rewardType=" + rewardType +
                ", grade=" + grade +
                '}';
    }
}
