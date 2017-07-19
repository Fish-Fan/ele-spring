package com.ele.mapper;

import com.ele.pojo.Like;
import com.ele.pojo.Shop;
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
     *
     * 用户登录
     * @param user
     * @return
     */
    User loginUser(User user);
    /**
     *
     * 用户登录状态
     * @param user
     * @return
     */
    User statusUser(User user);

    /**
     * 获取用户收藏商家列表
     * @param userId
     * @return
     */
    List<Like> getCollectShopByUserId(Integer userId);

    /**
     * 收藏商家
     * @param like
     */
    void collectShop(Like like);

    /**
     * 取消收藏商家
     * @param like
     */
    void uncollectShop(Like like);

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

    /**
     * 删除用户地址
     * @param userAddress
     */
    void delectUserAddress(UserAddress userAddress);

    /**
     * 增加用户地址
     * @param userAddress
     */
    void addAddress(UserAddress userAddress);

    /**
     * 更新用户头像
     * @param user
     */
    void updateAvatar(User user);

    /**
     * 更新用户名
     * @param user
     */
    void updateUserName(User user);

}
