package com.ele.service;

import com.ele.dto.DtoDiscountDesc;
import com.ele.dto.Goods;
import com.ele.mapper.RewardMapper;
import com.ele.mapper.ShopMapper;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopImg;
import com.ele.pojo.ShopReward;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
@Transactional
@Service
public class ShopService {
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private RewardMapper rewardMapper;

    /**
     * 根据商家ID查找商家
     * @param id
     * @return
     */
    public Shop findById(Integer id) {
        return shopMapper.findById(id);
    }

    /**
     * 根据商家ID查找商家折扣活动
     * @param id
     * @return
     */
    public List<DtoDiscountDesc> findDiscountDescById(Integer id) {
        return shopMapper.findDiscountDescById(id);
    }

    /**
     * 根据商家ID查找商家图片
     * @param id
     * @return
     */
    public List<ShopImg> findShopImgById(Integer id) {
        return shopMapper.findShopImgById(id);
    }

    /**
     * 根据商家ID查找货物
     * @param id
     * @return
     */
    public List<Goods> findShopGoodsById(Integer id) {
        return shopMapper.findShopGoodsById(id);
    }

    /**
     * 根据商家ID查找评论
     * @param shopId
     * @return
     */
    public  List<ShopReward> findShopRewardByShopId(Integer shopId) {
        return rewardMapper.findShopRewardByShopId(shopId);
    }

    /**
     * APP首页，展示前十名商家(按照服务评分进行排名)
     * @return
     */
    public List<Shop> findBasicShopMsgOrderByServer() {
        return shopMapper.findBasicShopMsgOrderByServer();
    }
}
