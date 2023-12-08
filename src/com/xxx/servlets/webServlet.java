package com.xxx.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 这里没有引入 @WebServlet 注解  要实例化这个servlet 需要web.xml 配置这个servlet
* */
public class webServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("通过web.xml配置的servlet请求成功.....");
        resp.setContentType("text/html;charset=utf-8");//配置编码格式
        resp.getWriter().println("通过web.xml配置的servlet请求成功");
    }
}
