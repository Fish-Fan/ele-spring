package com.ele.service;

import com.ele.mapper.ShopManagerMapper;
import com.ele.pojo.ShopManager;
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
    public ShopManager loginShop(ShopManager shopManager){
        ShopManager shopManager1 = shopManagerMapper.shopLogin(shopManager);
        if (shopManager1 != null){
            return shopManager1;
        }else {
            return null;
        }
    }
    /**
     * 商家注册
     * @param
     * @return
     */
    public Integer insertShop(ShopManager shopManager){
        shopManagerMapper.insertShop(shopManagerMapper);
        return shopManager.getShopId();
    }
}
