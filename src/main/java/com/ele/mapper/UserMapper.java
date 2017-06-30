package com.ele.mapper;

import com.ele.pojo.User;
import org.springframework.stereotype.Component;

/**
 * Created by yanfeng-mac on 2017/6/27.
 */
@Component
public interface UserMapper {
    User findById(Integer id);
}
