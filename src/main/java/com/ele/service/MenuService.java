package com.ele.service;

import com.ele.mapper.MenuMapper;
import com.ele.pojo.MenuTypeReal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Transactional
@Service
public class MenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 将商家添加到Menu
     * @param
     * @return
     */
    public MenuTypeReal insertShopToMenu(MenuTypeReal menuTypeReal){
       menuMapper.insertShopToMenu(menuTypeReal);
       return menuTypeReal;
    }
}
