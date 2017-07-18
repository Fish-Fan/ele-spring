package com.ele.controller;

import com.ele.dto.Goods;
import com.ele.pojo.*;
import com.ele.service.OrderService;
import com.ele.service.ShopManagerService;
import com.ele.service.ShopService;
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
    @Autowired
    private ShopService shopService;

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

    /**
     * 查询今日未接订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/status/2",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getUnGetOrderByNowDays() {
        List<Order> orderList = orderService.selectUnGetOrderByNowDays();
        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

    /**
     * 查询今日已接订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/status/3",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getGetOrderByNowDays() {
        List<Order> orderList = orderService.selectGetOrderByNowDays();
        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

    /**
     * 查询今日已完成订单
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/order/status/4",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getFinishOrderByNowDays() {
        List<Order> orderList = orderService.selectFinishOrderByNowDays();
        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

    /**
     * 查询商家信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/detail",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopDetail(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");
//        Integer id = shopManager.getShopId();
        Integer id = 1;

        Shop shop = shopService.findById(id);
        shop.setDiscountDescList(shopService.findDiscountDescById(id));
        shop.setImgList(shopService.findShopImgById(id));
        shop.setLikeCount(shopService.getShopCollectCount(id));
        Gson gson = new Gson();
        return gson.toJson(shop);
    }

    /**
     * 返回商家商品信息
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/goods/detail",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getShopGoods(HttpServletRequest req) {
        HttpSession session = req.getSession();
//        ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");
//        Integer id = shopManager.getShopId();
        Integer id = 1;
        List<Goods> goodsList = shopService.findShopGoodsById(id);

        Gson gson = new Gson();
        return gson.toJson(goodsList);
    }

    /**
     * 查询今日销售额
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/salesmount/day",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getNowDaysSaleAmount(HttpServletRequest req) {
        HttpSession session = req.getSession();
        ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");

        return shopManagerService.selectNowDaysSalesAmount(shopManager.getShopId()) + "";
    }

    /**
     * 查询本月销售额
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/salesmount/month",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getNowMonthSaleAmount(HttpServletRequest req) {
        HttpSession session = req.getSession();
        ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");

        return shopManagerService.selectNowMonthySalesAmount(shopManager.getShopId()) + "";
    }

    /**
     * 查询本年度销售额
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/salesmount/year",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getNowYearsSaleAmount(HttpServletRequest req) {
        HttpSession session = req.getSession();
        ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");

        return shopManagerService.selectNowYearSalesAmount(shopManager.getShopId()) + "";
    }

    /**
     * 商家添加商品
     * @param shopFood
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/goods/add",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String insertFoodToShop(@RequestBody ShopFood shopFood){
        Integer shopfoodid = shopManagerService.insertFoodToShop(shopFood);
        return shopfoodid+"";
    }
    /**
     * 商家更新商品
     * @param shopFood
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/goods/edit",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public void updateFoodToShop(@RequestBody ShopFood shopFood){
        shopManagerService.updateFoodToShop(shopFood);
    }
    /**
     * 商家删除商品
     * @param shopFood
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/goods/delete",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public void deleteFoodToShop(@RequestBody ShopFood shopFood){
        shopManagerService.deleteFoodToShop(shopFood.getId());
    }
    /**
     * 删除商家菜单种类
     * @param
     */
    @ResponseBody
    @RequestMapping(value = " /manager/shop/goodtype/delete",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public void deleteShopMenu(@RequestBody FoodType foodType){
        shopManagerService.deleteShopMenu(foodType.getFoodTypeId());
    }
    /**
     * 增加商家菜单种类
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/goodtype/add",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String insertShopMenu(@RequestBody FoodType foodType){
        Integer foodtypeid = shopManagerService.insertShopMenu(foodType);
        System.out.println(foodtypeid);
        return  foodtypeid+"";


    }
    /**
     * 更新商家菜单种类
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/goodtype/edit",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public void updateShopMenu(@RequestBody FoodType foodType){
        shopManagerService.updateShopMenu(foodType);
    }
    /**
     * 删除商家活动信息
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/discount/delete",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public void deleteShopActivity(@RequestBody ShopDiscountDesc shopDiscountDesc){
        shopManagerService.deleteShopActivity(shopDiscountDesc.getId());
    }
    /**
     * 增加商家活动信息
     * @param
     */
    @ResponseBody
    @RequestMapping(value = " /manager/shop/discount/add",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String insertShopActivity(@RequestBody ShopDiscountDesc shopDiscountDesc){
        Integer id = shopManagerService.insertShopActivity(shopDiscountDesc);
        return id+"";
    }
    /**
     * 更新商家活动信息
     * @param
     */
    @ResponseBody
    @RequestMapping(value = "/manager/shop/discount/edit",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public void updateShopActivity(@RequestBody ShopDiscountDesc shopDiscountDesc){
        shopManagerService.updateShopActivity(shopDiscountDesc);
    }

}
