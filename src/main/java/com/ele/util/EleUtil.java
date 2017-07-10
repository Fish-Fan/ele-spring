package com.ele.util;

import com.ele.pojo.OrderFood;
import com.ele.pojo.ShopFood;

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
}
