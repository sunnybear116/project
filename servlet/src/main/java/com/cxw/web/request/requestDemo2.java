package com.adbc.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

/**
 * 获取请求参数
 */
@WebServlet("/resdemo2")
public class requestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get he post ...");
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            System.out.print(key + ":");
            String[] values = map.get(key);
            for (String value : values) {
                System.out.println(value + " ");
            }
            System.out.println();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post ...");
//        Map<String, String[]> map = req.getParameterMap();
//        for (String key : map.keySet()) {
//            System.out.print(key + ":");
//            String[] values = map.get(key);
//            for (String value : values) {
//                System.out.println(value + " ");
//            }
//            System.out.println();
//        }
//        处理方式可以复用，所以，直接用一个就好
        this.doGet(req,resp);
    }
}
