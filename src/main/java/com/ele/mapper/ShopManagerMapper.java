package com.ele.mapper;

import com.ele.pojo.MenuType;
import com.ele.pojo.ShopManager;
import org.springframework.stereotype.Component;

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
}
