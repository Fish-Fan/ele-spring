package com.ele.mapper;

import com.ele.pojo.User;
import org.springframework.stereotype.Component;

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
}
