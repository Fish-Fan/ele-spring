package com.ele.controller;

import com.ele.pojo.ShopManager;
import com.ele.service.ShopManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
@Controller
public class ShopManagerController {
    @Autowired
    private ShopManagerService shopManagerService;

    /**
     * 商家登陆
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stor",method = RequestMethod.POST,produces ="application/json;charset=utf-8" )
    public String loginShop(HttpServletRequest request){
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("passWord");
        ShopManager shopManager = new ShopManager();
        shopManager.setPassWord(password);
        shopManager.setPhoneNum(phoneNum);
        ShopManager shopManager1 = shopManagerService.loginShop(shopManager);
        if (shopManager1 != null){
            return "success";
        }else {
            return "error";
        }
    }
    /**
     * 商家注册
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/store",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Integer registerShop(@RequestBody ShopManager shopManager, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (shopManagerService.insertShop(shopManager) != null){
            return shopManager.getShopId();
        }
        return null;
    }
}
