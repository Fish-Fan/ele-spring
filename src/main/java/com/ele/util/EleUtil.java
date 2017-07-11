package com.ele.util;

import com.ele.pojo.*;
import com.ele.service.OrderService;
import com.ele.service.ShopService;
import com.ele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
public class EleUtil {

    public static List<OrderFood> ShopFoodCastToOrderFood(List<ShopFood> foodList,Integer orderId) {
        List<OrderFood> orderFoodList = new ArrayList<>();
        for(ShopFood food: foodList) {
            OrderFood orderFood = new OrderFood();
            orderFood.setId(food.getId());
            orderFood.setOrderId(orderId);
            orderFood.setFoodCount(food.getCount());
            orderFood.setFoodName(food.getFoodName());
            orderFood.setFoodId(food.getId());

            orderFoodList.add(orderFood);
        }
        return orderFoodList;
    }

    public static boolean userHasOrder(User user, Integer orderId,OrderService orderService) {
        List<Order> orderList = orderService.findHistoryOrderByUserId(user.getId());
        for(Order order: orderList) {
            if(order.getId() == orderId)
                return true;
        }

        return false;
    }

    public static boolean userIsLikeShop(User user, Integer shopId, UserService userService) {
        List<Like> likeList = userService.getCollectShopByUserId(user.getId());
        for(Like like: likeList) {
            if(like.getShopId() == shopId)
                return true;
        }

        return false;
    }
}
