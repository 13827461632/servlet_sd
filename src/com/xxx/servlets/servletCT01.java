package com.xxx.servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "servletCT01", urlPatterns = "/xie02")
public class servletCT01 extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("转发成功.....");
        //转发地址栏不会改变

        //设置域对象（在请求转发中生效）
        servletRequest.setAttribute("Aname", "张三");
        servletRequest.setAttribute("Aage", "88");
        List<String> attrlist = List.of("1", "2", "3");
        servletRequest.setAttribute("attrlist", attrlist);
        //请求转发 共用一个Request 页面发送的数据  重定向的请那边也能获取到
//        System.out.println("转发请求.....");
//        servletRequest.getRequestDispatcher("/xie01").forward(servletRequest, servletResponse);
        //转发跳转页面 (请求转发 和请求转发页面同一个方法内只能生效第一个)
        servletRequest.getRequestDispatcher("dataview.jsp").forward(servletRequest, servletResponse);

        System.out.println("转发页面.....");
    }
}
