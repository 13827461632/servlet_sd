package com.xxx.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "servletCT04", value = "/xie04")
public class servletCT04 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //重定向 (域对象可以用)
        //重定向 地址会发生改变（页面传入的数据 是不共享的（），重定向的第二个请求是获取不到页面传送的数据  既 到 /xie01 那边是没有数据）
        resp.sendRedirect("/jun/xie01");//重定向请求
        //resp.sendRedirect("/jun/dataview.jsp");//重定向jsp
        //resp.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重写doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("重写doPost");
        super.doGet(req, resp);
    }
}
