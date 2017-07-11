package com.ele.mapper;

import com.ele.pojo.FoodReward;
import com.ele.pojo.OrderImg;
import com.ele.pojo.ShopReward;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/3.
 */
@Component
public interface RewardMapper {
    /**
     * 根据FOODID查找评论
     * @param foodId
     * @return
     */
    FoodReward findRewardByFoodId(Integer foodId);

    /**
     * 根据商家ID查找评论
     * @param shopId
     * @return
     */
    List<ShopReward> findShopRewardByShopId(Integer shopId);

    /**
     * 新增商家评论
     * @param shopReward
     */
    void insertShopReward(ShopReward shopReward);

    /**
     * 新增商品评论
     * @param foodRewardList
     */
    void insertFoodReward(List<FoodReward> foodRewardList);

    /**
     * 新增订单评论图片
     * @param orderImg
     */
    void insertOrderImg(OrderImg orderImg);
}
