package com.xxx.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class filterWebCT implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("web.xml配置的过滤器......>>fiterWebCT");
        servletResponse.setContentType("text/html;charset=UTF-8");

        //登陆验证 的列子
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession() ;//获取session
        String mgr = (String) session. getAttribute( "mgr");
        if(mgr!=null) {//登录过!
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            response.sendRedirect ( request.getContextPath()+"/index.html");//重定向首页
        }
        System.out.println("--->回来fiterWebCT过滤器--->");

    }
}
