package com.ele.mapper;

import com.ele.dto.OrderDetail;
import com.ele.pojo.Order;
import com.ele.pojo.OrderFood;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/7/10.
 */
@Component
public interface OrderMapper {
    /**
     * 新增订单
     * @param order
     */
    void insertOrder(Order order);

    /**
     * 插入该订单商品信息
     * @param orderFood
     */
    void insertFoodList(List<OrderFood> orderFood);

    /**
     * 根据订单ID查找订单
     * @param id
     * @return
     */
    Order findOrderById(Integer id);


    /**
     * 根据用户ID查找历史订单
     * @param userId
     * @return
     */
    List<Order> findHistoryOrderByUserId(Integer userId);

    /**
     * 更新订单信息
     * @param order
     */
    void updateOrder(Order order);
}
