package com.cxw.web;

import com.cxw.pojo.Brand;
import com.cxw.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    BrandService brandService = new BrandService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Brand> brands = brandService.selectAll();
        request.setAttribute("brands",brands);
        //转发不用写虚拟目录
        request.getRequestDispatcher("/show.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
