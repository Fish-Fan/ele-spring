package com.ele.mapper;

import com.ele.dto.DtoDiscountDesc;
import com.ele.dto.Goods;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopFood;
import com.ele.pojo.ShopImg;
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
}
