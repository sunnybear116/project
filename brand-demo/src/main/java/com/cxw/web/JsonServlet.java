package com.cxw.web;

import com.alibaba.fastjson.JSON;
import com.cxw.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/jsonServlet")
public class JsonServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        json数据接受，不能用getParameter(),使用getReader()
//        BufferedReader reader = request.getReader();
//        String s = reader.readLine();
        String s = request.getReader().readLine();
//        json数据 --> java
        User user = JSON.parseObject(s, User.class);
        System.out.println(user);
//        java --> json数据
        String s1 = JSON.toJSONString(user);
        System.out.println(s1);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
