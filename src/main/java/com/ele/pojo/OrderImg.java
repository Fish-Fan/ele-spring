package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/7/11.
 */
public class OrderImg {
    private Integer id;
    private Integer orderId;
    private String orderImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(String orderImg) {
        this.orderImg = orderImg;
    }

    @Override
    public String toString() {
        return "OrderImg{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", orderImg='" + orderImg + '\'' +
                '}';
    }
}
