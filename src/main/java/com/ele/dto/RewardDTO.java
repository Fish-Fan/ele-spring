package com.ele.dto;

import com.ele.pojo.FoodReward;
import com.ele.pojo.ShopReward;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
public class RewardDTO {


    /**
     * foodRewardList : [{"shopId":1,"shopFoodId":8,"userId":1,"avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","username":"fanyank","orderId":13,"rewardMsg":"<p><br><\/p>","grade":3},{"shopId":1,"shopFoodId":9,"userId":1,"avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","username":"fanyank","orderId":13,"rewardMsg":"<p><br><\/p>","grade":3}]
     * shopReward : {"userId":1,"avatar":"http://static.galileo.xiaojukeji.com/static/tms/default_header.png","username":"fanyank","orderId":13,"shopId":1,"rewardMsg":"<p><br><\/p>","grade":3}
     */

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

    @Override
    public String toString() {
        return "RewardDTO{" +
                "shopReward=" + shopReward +
                ", foodRewardList=" + foodRewardList +
                '}';
    }
}
