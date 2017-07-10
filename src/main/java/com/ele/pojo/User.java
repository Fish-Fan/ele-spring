package com.ele.pojo;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String avatar;
    private String phoneNum;
    private String weixin;
    private String lastAddress;
    private Integer status;

    private List<UserAddress> addressList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin;
    }

    public String getLastAddress() {
        return lastAddress;
    }

    public void setLastAddress(String lastAddress) {
        this.lastAddress = lastAddress;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<UserAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<UserAddress> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", weixin='" + weixin + '\'' +
                ", lastAddress='" + lastAddress + '\'' +
                ", status=" + status +
                ", addressList=" + addressList +
                '}';
    }
}
