package com.adbc.web;

import com.adbc.pojo.Brand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * jstl 标签
 */
@WebServlet("/JSTLServlet")
public class JSTLServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //jstl-if 测试
//        request.setAttribute("flag",0);
//        request.getRequestDispatcher("jstl-if.jsp").forward(request,response);
        //jstl-foreach 测试，重写原来的brand.jsp
        List<Brand> brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"三只松鼠","三只松鼠",100,"好吃",1));
        brands.add(new Brand(2,"优衣库","优衣库",200,"好穿",0));
        brands.add(new Brand(3,"小米","小米科技有限公司",1000,"好玩",1));
        request.setAttribute("brands", brands);
        request.getRequestDispatcher("jstl-foreach.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
