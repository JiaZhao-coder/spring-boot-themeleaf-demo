package com.km.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.km.mapper.UserMapper;
import com.km.pojo.User;
import com.km.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl  implements UserService
{


    // 注入mapper,mappersan是把mapper接口交给spring管理
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> checkLogin(String userName, String userPassword) {


        // 根据用户名和密码去查询 信息

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        // 设置条件
        queryWrapper.eq("user_name", userName);//为啥是字段名，明显，这个要拼接到where后面，sql语句的 原因
        queryWrapper.eq("user_password", userPassword);

        List<User> list = this.userMapper.selectList(queryWrapper);


        return list;
    }
}
