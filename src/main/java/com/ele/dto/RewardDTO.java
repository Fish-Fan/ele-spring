package com.ele.dto;

import com.ele.pojo.FoodReward;
import com.ele.pojo.ShopReward;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
public class RewardDTO {

    private ShopReward shopReward;
    private List<FoodReward> foodRewardList;

    public ShopReward getShopReward() {
        return shopReward;
    }

    public void setShopReward(ShopReward shopReward) {
        this.shopReward = shopReward;
    }

    public List<FoodReward> getFoodRewardList() {
        return foodRewardList;
    }

    public void setFoodRewardList(List<FoodReward> foodRewardList) {
        this.foodRewardList = foodRewardList;
    }
}
