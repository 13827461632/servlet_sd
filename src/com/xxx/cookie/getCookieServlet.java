package com.xxx.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/getCookieServlet")
public class getCookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----获取cookie值----->getCookieServlet");
       Cookie[] cookies =  req.getCookies();
        if (cookies != null){
           for (Cookie cookie: cookies){
               System.out.println("--------->Cookie name = " + URLDecoder.decode(cookie.getName(), StandardCharsets.UTF_8)); //因为前面进行了编码 这里要解码才能显示中文
               System.out.println("--------->Cookie value = " + URLDecoder.decode( cookie.getValue(), StandardCharsets.UTF_8));
           }
        }

        System.out.println("------>获取cookie值成功");
    }
}
