package com.ele.mapper;

import com.ele.dto.DtoDiscountDesc;
import com.ele.dto.Goods;
import com.ele.pojo.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/28.
 */
@Component
public interface ShopMapper {
    /**
     * 根据ID找商家
     * @param id
     * @return
     */
    Shop findById(Integer id);

    /**
     * 根绝商家ID查找折扣活动
     * @param id
     * @return
     */
    List<DtoDiscountDesc> findDiscountDescById(Integer id);

    /**
     * 根据商家ID查找商家图片
     * @param id
     * @return
     */
    List<ShopImg> findShopImgById(Integer id);

    /**
     * 根据商家ID查找货物
     * @param id
     * @return
     */
    List<Goods> findShopGoodsById(Integer id);

    /**
     * 根据FOODID查找食物
     * @param foodId
     * @return
     */
    ShopFood findFoodByFoodId(Integer foodId);

    /**
     * APP首页，展示前十名商家(按照服务评分进行排名)
     * @return
     */
    List<Shop> findBasicShopMsgOrderByServer();

    /**
     * 根据搜索内容查找名字类似的商家
     * @param searchValue
     * @return
     */
    List<Shop> findShopByLikeName(String searchValue);

    /**
     * 根据搜索内容查找商品
     * @param searchValue
     * @return
     */
    List<ShopFood> findFoodByLikeName(String searchValue);

    /**
     * 获取商家被收藏数量
     * @param shopId
     * @return
     */
    Integer getShopCollectCount(Integer shopId);
}
