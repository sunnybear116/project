package com.cxw.service;

import com.cxw.mapper.BrandMapper;
import com.cxw.mapper.UserMapper;
import com.cxw.pojo.Brand;
import com.cxw.pojo.User;
import com.cxw.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User login(String username,String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.select(username, password);
        sqlSession.close();
        return user;
    }

    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        String username = user.getUsername();
        User user1 = mapper.selectByUsername(username);
//      用户查询为空，用户不存在，可以注册
        if (user1 == null) {
            mapper.add(user);
        }
        sqlSession.close();
//        可以注册，返回真
        return user1 == null;
    }




    public void update(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.close();
    }
}
