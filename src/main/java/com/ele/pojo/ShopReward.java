package com.ele.pojo;

import com.ele.pojo.ShopFood;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/3.
 */
public class ShopReward {
    private Integer id;
    private Integer userId;
    private String username;
    private String avatar;
    private String rewardMsg;
    private Integer shopId;
    private Integer orderId;
    private Integer rewardType;
    private Integer grade;
    private String rewardTime;

    private List<ShopFood> foodList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public List<ShopFood> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<ShopFood> foodList) {
        this.foodList = foodList;
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

    public String getRewardTime() {
        return rewardTime;
    }

    public void setRewardTime(String rewardTime) {
        this.rewardTime = rewardTime;
    }

    @Override
    public String toString() {
        return "ShopReward{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", rewardMsg='" + rewardMsg + '\'' +
                ", shopId=" + shopId +
                ", orderId=" + orderId +
                ", rewardType=" + rewardType +
                ", grade=" + grade +
                ", rewardTime='" + rewardTime + '\'' +
                ", foodList=" + foodList +
                '}';
    }
}
