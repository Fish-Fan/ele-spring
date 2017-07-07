package com.ele.controller;

import com.ele.dto.OrderDetail;
import com.ele.pojo.Order;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/7.
 */
@Controller
@RequestMapping("/api/order")
public class OrderController {

    @ResponseBody
    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    public String getOrderDetail(@RequestBody OrderDetail orderDetail) {
        //MM大写区分时间和月份,HH大写是24小时制，hh小写是12小时制
        String now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        Order order = new Order();

        order.setUsername(orderDetail.getOrderDetail().getUser().getUsername());
        order.setPhoneNum(orderDetail.getOrderDetail().getUser().getPhoneNum());
        order.setNoName(true);
        order.setSumMoney(orderDetail.getOrderDetail().getTotalPrice());
        //设置地址(未完成)
        order.setAddress("111");
        order.setGenerateTime(now);
        order.setFoodList(orderDetail.getOrderDetail().getFoodList());
        order.setUser(orderDetail.getOrderDetail().getUser());



        return "111";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test() {
        return "test";
    }


}
