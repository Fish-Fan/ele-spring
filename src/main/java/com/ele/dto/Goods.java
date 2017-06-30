package com.ele.dto;

import com.ele.pojo.ShopFood;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/29.
 */
public class Goods {
    private String name;
    private Integer type;
    private List<ShopFood> foodList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<ShopFood> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<ShopFood> foodList) {
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", foodList=" + foodList +
                '}';
    }
}
