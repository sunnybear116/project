package com.cxw.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 对没有登录的用户拦截对资源的访问请求
 */
@WebFilter("/login.jsp")
public class FilterLogin implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        对登陆，注册，样式，图片等等资源放行，即使用户没有登陆
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/reigsterServlet","/checkCodeServlet"};
//        Filter里的ServletRequest需要转换成HttpServletRequest才能够使用
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
//        获取访问的URL
        String url = req.getRequestURL().toString();
//        判断是否访问标注资源
        for (String u:urls){
            if (url.contains(u)){
                chain.doFilter(request, response);
                return;
            }
        }
//        如果用户登陆，那么会携带Session信息，所以用session判断用户是否登陆
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
//            登陆,放行

//            注意：Filter放行参数是Filter里面的参数
            chain.doFilter(request,response);
        }else {
            req.setAttribute("login_msg","您还没有登陆");
            req.getRequestDispatcher("/login.jsp").forward(req,res);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
