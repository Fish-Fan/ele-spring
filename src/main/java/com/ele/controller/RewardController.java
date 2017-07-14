package com.ele.controller;

import com.ele.dto.RewardDTO;
import com.ele.pojo.Order;
import com.ele.pojo.OrderImg;
import com.ele.pojo.User;
import com.ele.service.OrderService;
import com.ele.service.RewardService;
import com.ele.service.UserService;
import com.ele.util.EleUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
@Controller
public class RewardController {
    @Autowired
    private RewardService rewardService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;


    /**
     * 接受用户的订单评论
     * @param rewardDTO
     * @param req
     * @param orderId
     */
    @ResponseBody
    @RequestMapping(value = "/user/reward/{orderId:\\d+}",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public String getUserReward(@RequestBody RewardDTO rewardDTO, HttpServletRequest req, @PathVariable Integer orderId) {
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);

        boolean result = EleUtil.userHasOrder(user,orderId,orderService);
        Order order = orderService.findOrderById(orderId);

        if(result) {
            rewardService.insertReward(rewardDTO,order);
            return "success";
        }
        return "error";
    }

    /**
     * 返回订单数据
     * @param orderId
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/reward/{orderId:\\d+}",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    public String returnUserOrder(@PathVariable Integer orderId,HttpServletRequest req) {
        HttpSession session = req.getSession();
//        User user = (User) session.getAttribute("user");
        User user = userService.findById(1);
        boolean result = EleUtil.userHasOrder(user,orderId,orderService);
        Order order = null;

        if(result) {
             order = orderService.findOrderById(orderId);
        }

        Gson gson = new Gson();
        return gson.toJson(order);
    }

    /**
     * 接受评论图片地址
     * @param req
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/user/reward/uploadimg",method = RequestMethod.POST,produces = "application/json;charset-utf-8")
    public String getUploadRewardImg(HttpServletRequest req) {
        String key = req.getParameter("key");
        String orderId = req.getParameter("orderId");

        OrderImg orderImg = new OrderImg();
        orderImg.setOrderId(new Integer(orderId));
        orderImg.setOrderImg(key);

        rewardService.insertOrderImg(orderImg);
        return "success";

    }
}
