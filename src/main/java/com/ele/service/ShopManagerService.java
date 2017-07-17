package com.ele.service;

import com.ele.mapper.ShopManagerMapper;
import com.ele.pojo.MenuType;
import com.ele.pojo.ShopManager;
import com.ele.util.ConfigProp;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
@Transactional
@Service
public class ShopManagerService {
    @Autowired
    private ShopManagerMapper shopManagerMapper;

    /**
     * 商家登陆
     * @param
     * @return
     */
    public ShopManager loginShopManager(ShopManager shopManager){
        shopManager.setPassword(DigestUtils.md5Hex(shopManager.getPassword() + ConfigProp.get("user.password.salt")));

        ShopManager shopManager1 = shopManagerMapper.shopLogin(shopManager);
        if(shopManager1 != null) {
            return shopManager1;
        } else {
            return null;
        }
    }

    /**
     * 商家注册
     * @param
     * @return
     */
    public Integer insertShopManager(ShopManager shopManager){
        shopManager.setPassword(DigestUtils.md5Hex(shopManager.getPassword() + ConfigProp.get("user.password.salt")));
        shopManagerMapper.insertShop(shopManager);
        return shopManager.getShopId();
    }

    /**
     * 增加菜单种类
     * @param
     */
    public MenuType insertMenuType(MenuType menuType){
        shopManagerMapper.insertMenuType(menuType);
        return menuType;
    }
    /**
     * 删除菜单种类
     * @param
     */
    public Integer deleteMenuType(Integer menuType){
        shopManagerMapper.deleteMenuType(menuType);
        return menuType;
    }
    /**
     * 更新菜单种类
     * @param
     */
    public MenuType updateMenuType(MenuType menuType){
        shopManagerMapper.updateMenuType(menuType);
        return menuType;
    }

    /**
     * 查询今日销售额
     * @param shopId
     * @return
     */
    public Integer selectNowDaysSalesAmount(Integer shopId) {
        return shopManagerMapper.selectNowDaysSalesAmount(shopId);
    }

    /**
     * 查询本月销售额
     * @param shopId
     * @return
     */
    public Integer selectNowMonthySalesAmount(Integer shopId) {
        return shopManagerMapper.selectNowMonthySalesAmount(shopId);
    }

    /**
     * 查询本年度销售额
     * @param shopId
     * @return
     */
    public Integer selectNowYearSalesAmount(Integer shopId) {
        return shopManagerMapper.selectNowYearSalesAmount(shopId);
    }
}
