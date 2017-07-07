package com.ele.pojo;

import com.ele.dto.BasicFoodDTO;

import java.util.List;

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
    private String address;
    private String generateTime;

    private List<BasicFoodDTO> foodList;
    private User user;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGenerateTime() {
        return generateTime;
    }

    public void setGenerateTime(String generateTime) {
        this.generateTime = generateTime;
    }

    public List<BasicFoodDTO> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<BasicFoodDTO> foodList) {
        this.foodList = foodList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", address='" + address + '\'' +
                ", generateTime='" + generateTime + '\'' +
                ", foodList=" + foodList +
                ", user=" + user +
                '}';
    }
}
