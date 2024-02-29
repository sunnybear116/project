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

/**
 * 用户登录程序
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        1.获取参数
        String username = request.getParameter("username1");
        String password = request.getParameter("password1");
//        2.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
//        3.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        4.获取mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        5.执行里面的status语句
        User user = userMapper.select(username, password);
//        6.释放资源
        sqlSession.close();
//        7.处理逻辑
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (user != null){
            writer.write("登陆成功");
        } else{
            writer.write("登陆失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
