package com.ele.service;

import com.ele.mapper.UserMapper;
import com.ele.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
