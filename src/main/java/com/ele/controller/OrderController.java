package com.ele.controller;

import com.ele.dto.OrderDetail;
import com.ele.pojo.Order;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopManager;
import com.ele.pojo.User;
import com.ele.service.OrderService;
import com.ele.service.ShopService;
import com.ele.service.UserService;
import com.ele.socket.SocketHandler;
import com.ele.util.EleUtil;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/7.
 */
@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private SocketHandler socketHandler;

    /**
     * 接受购物车提交的信息，并将页面跳转至下单界面
     * @param orderDetail
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getOrderDetail(@RequestBody OrderDetail orderDetail, HttpServletRequest req) {

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        Integer orderId = orderService.insertShopCartData(orderDetail,user);
        return orderId+"";

    }

    /**
     * 返回下单界面的数据
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay/{orderId:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String returnOrderDetail(@PathVariable Integer orderId) {
        Order order = orderService.findOrderById(orderId);
        Gson gson = new Gson();
        return gson.toJson(order);
    }

    /**
     * 接受下单界面的数据,并将页面跳转至确认支付的界面
     * @param order
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay/confirm",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String confirmOrder(@RequestBody Order order) {
        System.out.println(order);
        boolean result = EleUtil.checkIsNoName(order);
        if(result) {
            order = orderService.changeUserToNoName(order);
        }
        orderService.orderChanged(order);
        //confirmPay未完成
        return "server/user/confirmPay";
    }

    /**
     * 跳转至等待支付界面
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay/wait",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getWaitPay(@RequestParam Integer orderId) {
        Order order = orderService.findOrderById(orderId);
        Gson gson = new Gson();
        return gson.toJson(order);
    }

    /**
     * 返回支付结果
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay/wait/{orderId:\\d+}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String waitPay(HttpServletRequest req,@PathVariable("orderId") Integer orderId) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Order order = orderService.findOrderById(orderId);

        String result = req.getParameter("result");
        if(result.equals("true")) {
            orderService.orderPaid(order);
            ShopManager shopManager = (ShopManager) session.getAttribute("shopManager");
            Gson gson = new Gson();
            socketHandler.sendMessageToUser(shopManager,new TextMessage(gson.toJson(order)));
        } else {
            return "error";
        }



        return "success";
    }

    /**
     * 返回确认收货页面的订单信息
     * @param orderId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/finish",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String getConfirmOrderMsg(@RequestParam Integer orderId) {
        Order order = orderService.findOrderById(orderId);
        Gson gson = new Gson();
        return gson.toJson(order);
    }

    /**
     * 确认收货
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/finish",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String confirmGetDelivery(@RequestBody Order order) {
        System.out.println(order);
        Shop shop = shopService.findById(order.getShopId());
        orderService.confirmGetDelivery(order.getId(),shop);
        return "success";
    }



    /**
     * 返回用户的历史订单
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/history",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String ReturnHistoryOrder(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
//        User user = userService.findById(1);
        List<Order> orderList = orderService.findHistoryOrderByUserId(user.getId());

        Gson gson = new Gson();
        return gson.toJson(orderList);
    }

//    /**
//     * 返回订单详情页面订单数据
//     * @param orderId
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping(value = "/detail/{orderId:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
//    public String returnOrderDetail(@PathVariable Integer orderId) {
//        Order order = orderService.findOrderById(orderId);
//        Gson gson = new Gson();
//        return gson.toJson(order);
//    }


}
