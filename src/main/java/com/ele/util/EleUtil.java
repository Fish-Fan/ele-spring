package com.ele.util;

import com.ele.pojo.*;
import com.ele.service.OrderService;
import com.ele.service.ShopService;
import com.ele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
public class EleUtil {

    /**
     * 将ShopFood类型转换为OrderFood类型
     * @param foodList
     * @param orderId
     * @return
     */
    public static List<OrderFood> ShopFoodCastToOrderFood(List<ShopFood> foodList,Integer orderId) {
        List<OrderFood> orderFoodList = new ArrayList<>();
        for(ShopFood food: foodList) {
            OrderFood orderFood = new OrderFood();
            orderFood.setId(food.getId());
            orderFood.setOrderId(orderId);
            orderFood.setFoodCount(food.getCount());
            orderFood.setFoodName(food.getFoodName());
            orderFood.setFoodId(food.getId());
            orderFood.setFoodPrice(food.getPrice());

            orderFoodList.add(orderFood);
        }
        return orderFoodList;
    }

    /**
     * 检查用户是否拥有这个订单
     * @param user
     * @param orderId
     * @param orderService
     * @return
     */
    public static boolean userHasOrder(User user, Integer orderId,OrderService orderService) {
        List<Order> orderList = orderService.findHistoryOrderByUserId(user.getId());
        for(Order order: orderList) {
            if(order.getId() == orderId)
                return true;
        }

        return false;
    }

    /**
     * 检查用户是否收藏了这个商家
     * @param user
     * @param shopId
     * @param userService
     * @return
     */
    public static boolean userIsLikeShop(User user, Integer shopId, UserService userService) {
        List<Like> likeList = userService.getCollectShopByUserId(user.getId());
        for(Like like: likeList) {
            if(like.getShopId() == shopId)
                return true;
        }

        return false;
    }

    /**
     * 计算时间差，返回相差的分钟数
     * @param d1
     * @param d2
     * @return
     */
    public static long getTimeMinus(Date d1,Date d2) {
        // 毫秒ms
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000);
        return diffMinutes;
    }

    /**
     * 检查用户是否拥有该地址
     * @param user
     * @param addressId
     * @param userService
     * @return
     */
    public static boolean checkUserHasAddress(User user,Integer addressId,UserService userService) {
        List<UserAddress> addressList = userService.getUserAddress(user);
        for(UserAddress address: addressList) {
            if(address.getId() == addressId)
                return true;
        }

        return false;
    }

    /**
     * 检查是否是匿名用户
     * @param order
     * @return
     */
    public static boolean checkIsNoName(Order order) {
        String result = order.getIsNoName();
        if("true".equals(result)) {
            return true;
        }
        return false;
    }
}
