package com.ele.controller;

import com.ele.dto.OrderDetail;
import com.ele.pojo.Order;
import com.ele.pojo.User;
import com.ele.service.OrderService;
import com.ele.service.UserService;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        Integer orderId = orderService.insertShopCartData(orderDetail,user);
        return orderId+"";

    }

    /**
     * 返回下单界面的数据
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String returnOrderDetail(HttpServletRequest req,@RequestParam("orderId") Integer orderId1) {
        HttpSession session = req.getSession();
        Integer orderId = 13;

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
        orderService.orderChanged(order);
        //confirmPay未完成
        return "server/user/confirmPay";
    }

    /**
     * 跳转至等待支付界面
     * @return
     */
    @RequestMapping(value = "/pay/wait",method = RequestMethod.GET)
    public String getWaitPay() {
        //跳转至waitPay界面(未完成)
        return "server/user/waitPay";
    }

    /**
     * 返回支付结果
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/pay/wait",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String waitPay(HttpServletRequest req) {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        Integer orderId = (Integer) session.getAttribute("curr_order_id");

        String result = req.getParameter("result");
        if(result.equals("true")) {
            orderService.orderPaid(orderService.findOrderById(orderId));
        } else {
            return "error";
        }

        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/finish/{oredrId:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String confirmGetDelivery() {
        return null;
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
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);
        List<Order> orderList = orderService.findHistoryOrderByUserId(user.getId());

        Gson gson = new Gson();
        return gson.toJson(orderList);
    }


}
