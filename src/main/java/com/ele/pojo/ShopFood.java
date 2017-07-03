package com.ele.pojo;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class ShopFood {
    private Integer id;
    private String foodName;
    private Integer shopFoodType;
    private Integer shopId;
    private Double price;
    private Double oldPrice;
    private Integer monthlyCounts;
    private String foodImg;
    private String info;
    private String description;
    private Double grade;

    private List<FoodReward> foodRewardList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getShopFoodType() {
        return shopFoodType;
    }

    public void setShopFoodType(Integer shopFoodType) {
        this.shopFoodType = shopFoodType;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Integer getMonthlyCounts() {
        return monthlyCounts;
    }

    public void setMonthlyCounts(Integer monthlyCounts) {
        this.monthlyCounts = monthlyCounts;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public List<FoodReward> getFoodRewardList() {
        return foodRewardList;
    }

    public void setFoodRewardList(List<FoodReward> foodRewardList) {
        this.foodRewardList = foodRewardList;
    }

    @Override
    public String toString() {
        return "ShopFood{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", shopFoodType=" + shopFoodType +
                ", shopId=" + shopId +
                ", price=" + price +
                ", oldPrice=" + oldPrice +
                ", monthlyCounts=" + monthlyCounts +
                ", foodImg='" + foodImg + '\'' +
                ", info='" + info + '\'' +
                ", description='" + description + '\'' +
                ", grade=" + grade +
                ", rewardList=" + foodRewardList +
                '}';
    }
}
