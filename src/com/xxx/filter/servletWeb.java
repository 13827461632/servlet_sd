package com.xxx.filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class servletWeb extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletWeb");
        resp.getWriter().write("<<<<<<<通过web.xml配置filter过滤器 和 servlet >>>>>>>");
    }
}
