package com.ele.mapper;

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
     * @param shopManagerMapper
     */
    void insertShop(ShopManagerMapper shopManagerMapper);
}
