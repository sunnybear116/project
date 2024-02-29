package com.adbc.web;

import com.adbc.mapper.UserMapper;
import com.adbc.pojo.User;
import com.adbc.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        4.获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        5.执行里面的status语句
        User user = userMapper.selectByUsername(username);
//        6.处理逻辑
        if (user == null){
            userMapper.add(username,password);
            sqlSession.close();
        }else {
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.write("用户已占用");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
