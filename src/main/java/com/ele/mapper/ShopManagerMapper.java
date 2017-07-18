package com.ele.mapper;

import com.ele.pojo.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
@Component
public interface ShopManagerMapper {
    /**
     * 商家登录
     * @param // STOPSHIP: 2017/7/12 0012
     * @return
     */
    ShopManager shopLogin(ShopManager shopManager);

    /**
     * 商家注册
     * @param shopManager
     */
    void insertShop(ShopManager shopManager);

    /**
     * 增加菜单种类
     * @param
     */
    void insertMenuType(MenuType menuType);
    /**
     * 删除菜单种类
     * @param
     */
    void deleteMenuType(Integer menuTypeId);
    /**
     * 更新菜单种类
     * @param
     */
    void updateMenuType(MenuType menuType);

    /**
     * 查询今日销售额
     * @param shopId
     * @return
     */
    Integer selectNowDaysSalesAmount(Integer shopId);

    /**
     * 查询本月销售额
     * @param shopId
     * @return
     */
    Integer selectNowMonthySalesAmount(Integer shopId);

    /**
     * 查询本年度销售额
     * @param shopId
     * @return
     */
    Integer selectNowYearSalesAmount(Integer shopId);

    /**
     * 商家添加商品
     * @param shopFood
     */
    void insertFoodToShop(ShopFood shopFood);
    /**
     * 商家删除商品
     * @param Id
     */
    void deleteFoodToShop(Integer Id);
    /**
     * 商家更新商品
     * @param
     */
    void updateFoodToShop(ShopFood shopFood);
    /**
     * 根据食物ID查找用户的地址
     * @param shopfoodId
     * @return
     */
    List<ShopFood> getShopFood(Integer shopfoodId);
    /**
     * 删除商家菜单种类
     * @param
     */
    void deleteShopMenu(Integer foodType);
    /**
     * 增加商家菜单种类
     * @param
     */
    void insertShopMenu(FoodType foodType);
    /**
     * 更新商家菜单种类
     * @param
     */
    void updateShopMenu(FoodType foodType);
    /**
     * 删除商家活动信息
     * @param
     */
    void deleteShopActivity(Integer ShopDiscountDesc);
    /**
     * 增加商家活动信息
     * @param
     */
    void insertShopActivity(ShopDiscountDesc shopDiscountDesc);
    /**
     * 更新商家活动信息
     * @param
     */
    void updateShopActivity(ShopDiscountDesc shopDiscountDesc);
}
