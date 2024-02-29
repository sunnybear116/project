package com.adbc.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 响应字符流
 */
@WebServlet("/ResponseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        设置可以解析 HTML 标签，设置中文编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write("aaa");
        writer.write("你好");
        writer.write("<h1>aaa</h1>");
//        流不需要关闭
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
