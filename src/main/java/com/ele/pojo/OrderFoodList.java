package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class OrderFoodList {
    private Integer id;
    private Integer foodId;
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "OrderFoodList{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", orderId=" + orderId +
                '}';
    }
}
