package com.ele.service;

import com.ele.mapper.UserMapper;
import com.ele.pojo.Like;
import com.ele.pojo.Shop;
import com.ele.pojo.User;
import com.ele.pojo.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据ID查找用户
     * @param userId
     * @return
     */
    public User findById(Integer userId) {
        return userMapper.findById(userId);
    }

    /**
     * 用户登陆
     * @param user
     * @return
     */
    public User loginUser(User user) {

        User loginuser = userMapper.loginUser(user);
        if (loginuser != null) {
            loginuser.setStatus(1);
            userMapper.statusUser(loginuser);
            return user;
        } else {
            return null;
        }
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public boolean registUser(User user) {
        User checkUser = userMapper.findByEmail(user.getEmail());

        if(checkUser != null) {
            return false;
        } else {
            userMapper.insertUser(user);
            return true;
        }
    }

    /**
     * 获取用户地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddress(Integer userId) {
        return userMapper.getUserAddress(userId);
    }

    /**
     * 更新用户地址
     * @param userAddress
     */
    public void updateUserAddress(UserAddress userAddress) {
        userMapper.updateUserAddress(userAddress);
    }

    /**
     * 获取用户收藏商家列表
     * @param userId
     */
    public List<Like> getCollectShopByUserId(Integer userId){
        return userMapper.getCollectShopByUserId(userId);
    }

    /**
     * 收藏商家
     * @param like
     */
    public void collectShop(Like like) {
        userMapper.collectShop(like);
    }

    /**
     * 取消收藏商家
     * @param like
     */
    public void unCollectShop(Like like){
        userMapper.uncollectShop(like);
    }

    /**
     * 增加用户地址
     * @param userAddress
     */
    public void addUserAddress(UserAddress userAddress){
        userMapper.addAddress(userAddress);
    }
    /**
     * 删除用户地址
     * @param userAddress
     */
    public void delectUserAddress(UserAddress userAddress){
        userMapper.delectUserAddress(userAddress);
    }
}
