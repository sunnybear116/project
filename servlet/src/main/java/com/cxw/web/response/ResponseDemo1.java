package com.adbc.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 重定向到ResponseDemo2
 */
@WebServlet("/ResponseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1...");
//        通过request.getContextPath() 获取虚拟目录，拼接到重定向地址，重定向地址需要前方添加虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/ResponseDemo2");
    }
}
