package com.adbc.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 响应字节流
 */
@WebServlet("/ResponseDemo3")
public class ResponseDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        读取文件
        FileInputStream fileInputStream = new FileInputStream("d://Lenna.jpg");
//        获取字节输出流
        ServletOutputStream os = response.getOutputStream();
//        复制流，使用工具类 IOUtils
        IOUtils.copy(fileInputStream,os);
//        关闭流，输出流同样不需要关闭
        fileInputStream.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
