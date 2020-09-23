package com.km.service;

import com.km.pojo.User;

import java.util.List;

public interface UserService {
    List<User> checkLogin(String userName,String userPassword);

}
