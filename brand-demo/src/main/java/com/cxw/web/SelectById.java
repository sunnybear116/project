package com.cxw.web;

import com.cxw.pojo.Brand;
import com.cxw.service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/selectById")
public class SelectById extends HttpServlet {

    BrandService brandService = new BrandService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        Brand brand = brandService.selectById(id);
        request.setAttribute("brand",brand);
        request.getRequestDispatcher("update.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
