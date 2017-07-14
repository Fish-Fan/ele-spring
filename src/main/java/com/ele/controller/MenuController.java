package com.ele.controller;

import com.ele.pojo.MenuType;
import com.ele.pojo.MenuTypeReal;
import com.ele.pojo.Shop;
import com.ele.service.MenuService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12 0012.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private  MenuService menuService;

    /**
     * 将商家添加到Menu
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String insertShopToMenu(@RequestBody MenuTypeReal menuTypeReal){
        if (menuTypeReal != null){
            menuService.insertShopToMenu(menuTypeReal);
            return "success";
        }else {
            return "error";
        }
    }

    /**
     * 返回商家信息(根据Menu_Type_Id查找)
     * @param request
     * @return List<Shop>
     */

    @ResponseBody
    @RequestMapping(value = "/**",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String returnShopMessage(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        MenuType menuType = new MenuType();
        List<Shop> shopList = menuService.selectShopFoodByMenuTypeId(menuType.getMenuTypeId());
        Gson gson = new Gson();
        return gson.toJson(shopList);
    }

}
