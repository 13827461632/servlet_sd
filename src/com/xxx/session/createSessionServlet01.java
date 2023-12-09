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
@WebServlet("/ctsession01")
public class createSessionServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("---------------ctsession01------------------->");
        //获取当前会话session
        HttpSession session = req.getSession();
        System.out.println("session web过期时间------>"+session.getMaxInactiveInterval());
        System.out.println("session web到期时间------>"+session.getMaxInactiveInterval()/60+"分钟");
        //  session 底层是依赖 cookie的，Cookie数据只存在浏览器内存中.关闭浏览器 session 即失效
        //  session.invalidate();//这个是设置是 立马失效session 一般用于用户退出登陆


        session.setMaxInactiveInterval(60);// 这里设置 单位：秒 设置session的过期时间  web.xml中也可以设置session的过期时间无效（选其中一个即可）


        int ms = session.getMaxInactiveInterval()/60;//秒转分钟
        System.out.println("session 过期时间------>"+session.getMaxInactiveInterval());
        System.out.println("session 到期时间------>"+ms+"分钟");
        System.out.println("判断ctsession01是否是新的---->"+session.isNew());
        //设置域对象
        session.setAttribute("uage" , "age");//设置域对象
        System.out.println("获取域对象-----ctsession01-- uname-->"+session.getAttribute("uname"));
        session.removeAttribute("uname" ); //删除域对象
        System.out.println("删除域对象---uname--->");



    }
}
