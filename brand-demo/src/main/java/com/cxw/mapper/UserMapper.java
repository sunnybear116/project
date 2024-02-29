package com.cxw.mapper;

import com.cxw.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User select(@Param("username") String username,@Param("password") String password);

    User selectByUsername(String username);

    void add(User user);
}
