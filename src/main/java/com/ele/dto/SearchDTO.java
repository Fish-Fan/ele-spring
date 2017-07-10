package com.ele.dto;

import com.ele.pojo.Shop;
import com.ele.pojo.ShopFood;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
public class SearchDTO {
    private List<Shop> shopList;
    private List<ShopFood> foodList;

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public List<ShopFood> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<ShopFood> foodList) {
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "shopList=" + shopList +
                ", foodList=" + foodList +
                '}';
    }
}
