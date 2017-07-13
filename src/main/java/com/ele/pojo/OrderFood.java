package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class OrderFood {
    private Integer id;
    private Integer foodId;
    private String foodName;
    private Integer orderId;
    private Integer foodCount;
    private Double foodPrice;

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

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(Integer foodCount) {
        this.foodCount = foodCount;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
                "id=" + id +
                ", foodId=" + foodId +
                ", foodName='" + foodName + '\'' +
                ", orderId=" + orderId +
                ", foodCount=" + foodCount +
                ", foodPrice=" + foodPrice +
                '}';
    }
}
