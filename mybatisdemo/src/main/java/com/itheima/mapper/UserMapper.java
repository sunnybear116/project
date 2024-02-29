package com.itheima.mapper;

import com.itheima.pojo.User;

import java.util.List;

public interface UserMapper {

//    在mapper接口中定义方法，方法名需要和映射文件的 id 一致
    List<User> selectAll();

    User selectById(int id);
}
