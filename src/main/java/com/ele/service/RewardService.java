package com.ele.service;

import com.ele.dto.RewardDTO;
import com.ele.mapper.RewardMapper;
import com.ele.pojo.OrderImg;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void insertReward(RewardDTO rewardDTO) {
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
}
