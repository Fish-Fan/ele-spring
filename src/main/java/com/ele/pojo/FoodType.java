package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class FoodType {
    private Integer foodTypeId;
    private String shopFoodType;
    private Integer shopId;
    private Integer iconId;

    public Integer getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Integer foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getShopFoodType() {
        return shopFoodType;
    }

    public void setShopFoodType(String shopFoodType) {
        this.shopFoodType = shopFoodType;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getIconId() {
        return iconId;
    }

    public void setIconId(Integer iconId) {
        this.iconId = iconId;
    }

    @Override
    public String toString() {
        return "FoodType{" +
                "foodTypeId=" + foodTypeId +
                ", shopFoodType='" + shopFoodType + '\'' +
                ", shopId=" + shopId +
                ", iconId=" + iconId +
                '}';
    }
}
