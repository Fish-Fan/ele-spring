package com.ele.dto;

/**
 * Created by yanfeng-mac on 2017/7/7.
 */
public class BasicFoodDTO {
    private String foodName;
    private int price;
    private int count;

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
