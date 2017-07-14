package com.ele.mapper;

import com.ele.pojo.MenuTypeReal;
import com.ele.pojo.Shop;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Component
public interface MenuMapper {
    /**
     * 将商家添加到Menu
     * @param
     * @param menuTypeReal
     */
    void insertShopToMenu(MenuTypeReal menuTypeReal);

    /**
     * 根据菜单查找商家
     * @param
     * @param
     */
    List<Shop> selectShopFoodByMenuTypeId(Integer shopId);
}
