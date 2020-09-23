package com.km.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.km.pojo.User;

//继承接口里面的<泛型不要忘写了，否则运行不起>,只是继承，里面不要写抽象方法，继承的父亲底层写好了
public interface UserMapper extends BaseMapper<User> {

}
