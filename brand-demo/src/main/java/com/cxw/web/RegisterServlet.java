package com.cxw.web;

import com.cxw.pojo.User;
import com.cxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

//        获取用户填写的验证码
        String checkCode = request.getParameter("checkCode");
//        获取程序生成的验证码
        HttpSession session = request.getSession();
        Object checkCode1 = session.getAttribute("checkCode");


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        if (!checkCode.equals(checkCode1)){
            request.setAttribute("register_msg","验证码不正确");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return;
        }

        boolean flag = userService.register(user);
//        用户未存在，注册成功，返回值为真，跳转到登陆页面，携带提示信息：注册成功，请登录
        if (flag){
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{
            request.setAttribute("register_msg","用户已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
