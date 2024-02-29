package com.adbc.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 请求转发，数据共享
 */
@WebServlet("/demo4")
public class requestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo4...");
        request.setAttribute("msg","hello demo4 and 5");
        request.getRequestDispatcher("/demo5").forward(request,response);
    }
}
