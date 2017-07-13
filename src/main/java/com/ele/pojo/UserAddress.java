package com.ele.pojo;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class UserAddress {
    private Integer id;
    private Integer userId;
    private String username;
    private String phoneNum;
    private String userAddress;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
