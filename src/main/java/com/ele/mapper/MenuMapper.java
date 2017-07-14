package com.ele.mapper;

import com.ele.pojo.MenuTypeReal;
import org.springframework.stereotype.Component;

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
}
