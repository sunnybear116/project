package com.cxw.web;

import com.cxw.pojo.User;
import com.cxw.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);

//        如果用户存在，重定向到品牌展示页面selectAllServlet
//        为什么使用重定向，转发也可以，此处是为了测试session
//        重定向为不同的两次请求，两次请求间数据共享需要使用会话跟踪技术
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            if ("1".equals(request.getParameter("remember"))){
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                c_username.setMaxAge(60 * 60 *24);
                c_password.setMaxAge(60 * 60 *24);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            //重定向需要虚拟地址，建议动态获取
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/selectAllServlet");
        }else
            //用户不存在，转发到原来的页面，携带信息，提示用户密码错误
        {
            request.setAttribute("login_msg","用户名或者密码错误啦");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
