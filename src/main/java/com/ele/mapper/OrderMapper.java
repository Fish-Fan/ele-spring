package com.ele.mapper;

import com.ele.dto.OrderDetail;
import com.ele.pojo.Order;
import com.ele.pojo.OrderFood;
import com.ele.pojo.Shop;
import com.ele.pojo.ShopFood;
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

    /**
     * 计算最新商家平均送达时间
     * @param shopId
     * @return
     */
    Double computedDeliveryTime(Integer shopId);

    /**
     * 更新商家平均送达时间
     * @param shop
     */
    void updateShopDeliveryTime(Shop shop);

    /**
     * 根据商品ID查找商品
     * @param id
     * @return
     */
    ShopFood findGoodById(Integer id);

    /**
     * 更新商品月销量
     * @param shopFood
     */
    void updateGoodMonthlyCount(ShopFood shopFood);

    /**
     * 按天查找订单
     * @param shopId
     * @return
     */
    List<Order> selectOrderByDay(Integer shopId);

    /**
     * 按周查找订单
     * @param shopId
     * @return
     */
    List<Order> selectOrderByWeek(Integer shopId);

    /**
     * 按月查找订单
     * @param shopId
     * @return
     */
    List<Order> selectOrderByMonth(Integer shopId);

    /**
     * 查询今日未接订单
     * @return
     */
    List<Order> selectUnGetOrderByNowDays();

    /**
     * 查询今日已接订单
     * @return
     */
    List<Order> selectGetOrderByNowDays();

    /**
     * 查询今日已完成订单
     * @return
     */
    List<Order> selectFinishOrderByNowDays();
}
