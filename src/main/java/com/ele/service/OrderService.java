package com.ele.service;

import com.ele.dto.OrderDetail;
import com.ele.mapper.OrderMapper;
import com.ele.pojo.Order;
import com.ele.pojo.OrderFood;
import com.ele.pojo.ShopFood;
import com.ele.pojo.User;
import com.ele.util.EleUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 新增订单
     * @param orderDetail
     * @param user
     */
    public Integer insertShopCartData(OrderDetail orderDetail, User user) {
        List<ShopFood> foodList = orderDetail.getOrderDetail().getFoodList();
        //MM大写区分时间和月份,HH大写是24小时制，hh小写是12小时制
        String now = DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
        Order order = new Order();

        order.setUsername(user.getUsername());
        order.setAvatar(user.getAvatar());
        order.setPhoneNum(user.getPhoneNum());
        order.setNoName(true);
        order.setSumMoney(orderDetail.getOrderDetail().getTotalPrice());
        order.setAddress(user.getLastAddress());
        order.setGenerateTime(now);
        order.setUserId(user.getId());
        order.setUser(user);
        order.setStatus(0);
        order.setShopId(orderDetail.getOrderDetail().getFoodList().get(0).getShopId());

        Integer orderId = insertOrder(order);
        order.setFoodList(EleUtil.ShopFoodCastToOrderFood(foodList,orderId));
        insertFoodList(order.getFoodList());

        return orderId;
    }

    public Integer insertOrder(Order order) {
        orderMapper.insertOrder(order);
        return order.getId();
    }

    public void insertFoodList(List<OrderFood> foodList) {
        orderMapper.insertFoodList(foodList);
    }

    /**
     * 根据订单ID查找订单，包括订单内的商品
     * @return
     */
    public Order findOrderById(Integer orderId) {
        Order order = orderMapper.findOrderById(orderId);
        return order;
    }

    /**
     * 根据用户ID查找历史订单
     * @param userId
     * @return
     */
    public List<Order> findHistoryOrderByUserId(Integer userId) {
        return orderMapper.findHistoryOrderByUserId(userId);
    }

    /**
     * 变订单状态为已支付状态
     * @param order
     */
    public void orderPaid(Order order) {
        order.setStatus(1);
        orderMapper.updateOrder(order);
    }

    /**
     * 更新订单
     * @param order
     */
    public void orderChanged(Order order) {
        orderMapper.updateOrder(order);
    }

    public void confirmGetDelivery(Integer orderId) {
        Order order = orderMapper.findOrderById(orderId);
        String generateTime = order.getGenerateTime();

        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            DateTime now = new DateTime();
            String finishTime = now.toString("yyyy-MM-dd HH:mm:ss");
            Date d1 = format.parse(generateTime);
            Date d2 = format.parse(finishTime);
            long minus = EleUtil.getTimeMinus(d1,d2);

            order.setFinishTime(finishTime);
            order.setDeliveryTime(minus);
            order.setStatus(2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        orderChanged(order);

    }

}
