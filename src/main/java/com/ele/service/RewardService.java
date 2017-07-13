package com.ele.service;

import com.ele.dto.RewardDTO;
import com.ele.mapper.RewardMapper;
import com.ele.pojo.FoodReward;
import com.ele.pojo.Order;
import com.ele.pojo.OrderImg;
import com.ele.pojo.ShopReward;
import com.ele.util.EleUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
@Service
@Transactional
public class RewardService {
    @Autowired
    private RewardMapper rewardMapper;

    /**
     * 新增订单评论
     * @param rewardDTO
     */
    public void insertReward(RewardDTO rewardDTO, Order order) {
        boolean result = EleUtil.checkIsNoName(order);
        if(result) {
            ShopReward shopReward = rewardDTO.getShopReward();
            List<FoodReward> foodRewardList = rewardDTO.getFoodRewardList();

            changeRewardToNoName(shopReward);
            changeFoodRewardToNoName(foodRewardList);
        }

        rewardMapper.insertShopReward(rewardDTO.getShopReward());
        rewardMapper.insertFoodReward(rewardDTO.getFoodRewardList());
    }

    /**
     * 新增订单评论图片
     * @param orderImg
     */
    public void insertOrderImg(OrderImg orderImg) {
        rewardMapper.insertOrderImg(orderImg);
    }

    /**
     * 将评论转为匿名用户评论
     * @param shopReward
     * @return
     */
    public ShopReward changeRewardToNoName(ShopReward shopReward) {
        shopReward.setUsername("匿名用户");
        shopReward.setAvatar("匿名用户的头像");
        return shopReward;
    }

    /**
     * 将商品评论转化为匿名用户评论
     * @param foodRewardList
     * @return
     */
    public List<FoodReward> changeFoodRewardToNoName(List<FoodReward> foodRewardList) {
        for(FoodReward foodReward: foodRewardList) {
            foodReward.setUsername("匿名用户");
            foodReward.setAvatar("匿名用户的头像");
        }
        return foodRewardList;
    }
}
