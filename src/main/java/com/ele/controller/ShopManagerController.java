package com.ele.controller;

import com.ele.pojo.MenuType;
import com.ele.pojo.Order;
import com.ele.pojo.ShopManager;
import com.ele.service.OrderService;
import com.ele.service.ShopManagerService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/13.
 */
@Controller
public class ShopManagerController {
    @Autowired
    private ShopManagerService shopManagerService;
    @Autowired
    private OrderService orderService;

    /**
     * 商家登陆
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/login",method = RequestMethod.POST,produces ="application/json;charset=utf-8" )
    public String loginShop(HttpServletRequest request){
        String phoneNum = request.getParameter("phoneNum");
        String password = request.getParameter("passWord");
        ShopManager shopManager = new ShopManager();
        shopManager.setPassword(password);
        shopManager.setPhoneNum(phoneNum);
        ShopManager shopManager1 = shopManagerService.loginShopManager(shopManager);

        HttpSession session = request.getSession();
        session.setAttribute("shopManager",shopManager1);
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
    @RequestMapping(value = "/manager/shop/register",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public Integer registerShop(@RequestBody ShopManager shopManager, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (shopManagerService.insertShopManager(shopManager) != null){
            return shopManager.getShopId();
        }
        return null;
    }

    /**
     * 增加菜单种类
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/stor3",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public void insertMenuType(@RequestBody MenuType menuType){
        shopManagerService.insertMenuType(menuType);
    }
    /**
     * 删除菜单种类
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/store1",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public void deleteMenuType(@RequestBody MenuType menuType){
        shopManagerService.deleteMenuType(menuType.getMenuTypeId());
    }
    /**
     * 更新菜单种类
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/store2",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public void updateMenuType(@RequestBody MenuType menuType){
        shopManagerService.updateMenuType(menuType);
    }

    /**
     * 按天查找订单
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/view/day",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getOrderByDay(HttpServletRequest req) {
        Integer shopId = new Integer(req.getParameter("shopId"));
        List<Order> orderList = orderService.selectOrderByDay(shopId);

        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

    /**
     * 按周查找订单
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/view/week",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getOrderByWeek(HttpServletRequest req) {
        Integer shopId = new Integer(req.getParameter("shopId"));
        List<Order> orderList = orderService.selectOrderByWeek(shopId);

        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

    /**
     * 按月查找订单
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/view/month",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getOrderByMonth(HttpServletRequest req) {
        Integer shopId = new Integer(req.getParameter("shopId"));
        List<Order> orderList = orderService.selectOrderByMonth(shopId);

        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/status/2",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getUnGetOrderByNowDays() {
        List<Order> orderList = null;
        return null;
    }


}
