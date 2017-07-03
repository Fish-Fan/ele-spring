package com.ele.mapper;

import com.ele.pojo.FoodReward;
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
}
