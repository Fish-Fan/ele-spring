package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class Order {
    private Integer id;
    private String username;
    private String phoneNum;
    private Boolean isNoName;
    private String orderRemark;
    private Double sumMoney;
    private Integer userId;
    private String deliveryTime;
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Boolean getNoName() {
        return isNoName;
    }

    public void setNoName(Boolean noName) {
        isNoName = noName;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", isNoName=" + isNoName +
                ", orderRemark='" + orderRemark + '\'' +
                ", sumMoney=" + sumMoney +
                ", userId=" + userId +
                ", deliveryTime='" + deliveryTime + '\'' +
                ", grade=" + grade +
                '}';
    }
}
