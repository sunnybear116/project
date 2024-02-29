package com.adbc.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 获取请求行，请求头
 */
@WebServlet("/resdemo1")
public class requestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        StringBuffer requestURL = req.getRequestURL();
        System.out.println(requestURL);
        String requestURI = req.getRequestURI();
        System.out.println(requestURI);
        String queryString = req.getQueryString();
        System.out.println(queryString);

//        获取请求头
        String useragent = req.getHeader("User-Agent");
        System.out.println(useragent);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        String s = reader.readLine();
        System.out.println(s);
    }
}
