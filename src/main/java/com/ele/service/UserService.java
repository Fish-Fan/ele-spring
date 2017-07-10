package com.ele.service;

import com.ele.mapper.UserMapper;
import com.ele.pojo.User;
import com.ele.pojo.UserAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
