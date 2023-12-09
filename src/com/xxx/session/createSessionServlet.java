package com.xxx.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 当获取session对象时。会先判断session是否存在。如果存在则获取session对象。不存在则创建session对象
 *
 * session 作用域
 *
 * 请求转发
 *      一次请求
 *          request作用域有效
 *          session作用域有效
 * 重定向
 *      两次请求
 *          request作用域无效
 *          session作用域有效
 *
 */
@WebServlet("/ctsession")
public class createSessionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当获取session对象时。会先判断session是否存在。如果存在则获取session对象。不存在则创建session对象

        System.out.println("---------------ctsession------------------->");
        //获取当前会话session
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒");
        HttpSession session = req.getSession();
       // session.setMaxInactiveInterval(4564);//设置session的过期时间  web.xml中也可以设置session的过期时间无效（选其中一个即可）都配置了的话以代码里为准
        int ms = session.getMaxInactiveInterval()/60;//秒转分钟
        System.out.println("session 过期时间------>"+session.getMaxInactiveInterval());
        System.out.println("session 到期时间------>"+ms+"分钟");

        //获取session会话的唯一标识符
        String id = session.getId();
        System.out.println("session唯一标识----->"+id);
        //获取session创建时间
        String creationTime = sdf2.format(new Date(Long.parseLong(String.valueOf(session.getCreationTime()))));//session.getCreationTime()获取的是时间搓
        System.out.println("获取session创建时间---->"+creationTime);
        //获取session最后一次访问时间
        String lastAccessedTime = sdf2.format(new Date(Long.parseLong(String.valueOf(session.getLastAccessedTime()))));//session.getLastAccessedTime()获取的是时间搓
        System.out.println("获取session最后一次访问时间---->"+lastAccessedTime);
        //判断session是否是新的
        System.out.println("判断session是否是新的---->"+session.isNew());
        //设置域对象
        session.setAttribute("uname" , "admin");//设置域对象

        System.out.println("获取域对象-----ctsession---->"+session.getAttribute("uname"));
        System.out.println("获取域对象---uage------>"+session.getAttribute("uage"));
       // session.removeAttribute("uname" ); //删除域对象


    }
}
