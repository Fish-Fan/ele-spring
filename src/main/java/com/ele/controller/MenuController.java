package com.ele.controller;

import com.ele.pojo.MenuTypeReal;
import com.ele.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
