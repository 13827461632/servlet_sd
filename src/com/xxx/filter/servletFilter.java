package com.xxx.filter;



import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class servletFilter extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //启动服务器不会初始 servlet init方法  除非在web.xml配置servlet <load-on-startup>1</load-on-startup>启动服务器就实例化servlet 才会执行init方法
        System.out.println("---->看看启动服务器会初始servlet吗");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("过滤器结果乱码问题......");
        resp.getWriter().write("过滤解决乱码成功.....");
    }
}
