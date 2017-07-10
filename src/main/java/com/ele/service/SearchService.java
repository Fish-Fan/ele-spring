package com.ele.service;

import com.ele.mapper.ShopMapper;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
@Transactional
@Service
public class SearchService {
    @Autowired
    private ShopMapper shopMapper;

    /**
     * 搜索:根据搜索内容查找商家
     * @param searchValue
     * @return
     */
    public List<Shop> findShopByLikeName(String searchValue) {
        return shopMapper.findShopByLikeName(searchValue);
    }

    /**
     * 搜索:根据搜索内容查找商品
     * @param searchValue
     * @return
     */
    public List<ShopFood> findFoodByLikeName(String searchValue) {
        return shopMapper.findFoodByLikeName(searchValue);
    }
}
