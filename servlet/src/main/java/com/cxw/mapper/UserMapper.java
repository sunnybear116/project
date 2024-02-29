package com.adbc.mapper;

import com.adbc.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
        //在mapper接口中定义方法，方法名需要和映射文件的 id 一致
    User select (@Param("username") String username, @Param("password") String password);

    User selectByUsername (String username);

    void add(@Param("username") String username,@Param("password") String password);
}
