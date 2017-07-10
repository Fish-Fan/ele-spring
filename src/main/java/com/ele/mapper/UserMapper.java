package com.ele.mapper;

import com.ele.pojo.User;
import com.ele.pojo.UserAddress;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Component
public interface UserMapper {
    /**
     * 根据ID查找用户
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 插入新用户
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据Email查找用户
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 根据用户ID查找用户的地址
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddress(Integer userId);

    /**
     * 更新用户地址
     * @param userAddress
     */
    void updateUserAddress(UserAddress userAddress);
}
