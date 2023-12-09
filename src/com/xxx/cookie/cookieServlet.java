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


@WebServlet("/cookieServlet")
public class cookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       // Cookie cookie4 = new Cookie("存中文会报错","懂OR不懂" );

        //cookie 是不能出现中文的。存中文会报错
        String name = "";
        String value = "";
        name = URLDecoder.decode("name", StandardCharsets.UTF_8) ;//对中文编码
        value = URLDecoder.decode("张三", StandardCharsets.UTF_8) ;//对中文编码

        //设置cookie 值
        Cookie cookie = new Cookie(name,value );
        //过期时间
        cookie.setMaxAge(-1);//不设置默认为-1,如果设置值为-1,表示cookie只存活于浏览器,一旦浏览关闭cookie就会消失

        name = URLDecoder.decode("name2", StandardCharsets.UTF_8) ;
        value = URLDecoder.decode("张三2", StandardCharsets.UTF_8) ;
        Cookie cookie1 = new Cookie(name,value );
        //设置cookie 30秒过期时间
        cookie1.setMaxAge(30);//设置大于0表示浏览器存储多少秒,设置等于0表示删除该cookie

        name = URLDecoder.decode("name3", StandardCharsets.UTF_8) ;
        value = URLDecoder.decode("张三3", StandardCharsets.UTF_8) ;
        Cookie cookie2 = new Cookie(name,value );
        //删除cookie
        cookie2.setMaxAge(0);//,设置等于0表示删除该cookie

        //发送重复的cookie会覆盖之前的值  之前name2的值为 张三2，下面的代码就会把name2的值跟新为 张三4
        name = URLDecoder.decode("name2", StandardCharsets.UTF_8) ;
        value = URLDecoder.decode("张三4", StandardCharsets.UTF_8) ;
        Cookie cookie3 = new Cookie(name,value );
        cookie3.setMaxAge(30);


        cookie.setPath("/");//表示当前服务下任何资源都可以访问到当前cookie （不写默认不设置cookie的path） (疑问看tomcat怎么启动 不写怎么设置默认值的?)

//        cookie.setPath("/cookieServlet");//当前项目下的资源可获取cookie对象 或者设置为当前站点名 /cookieServlet
//        cookie.setPath("/getCookieServlet");//设置指定其他站点名 设置具体请求能获取的cookie
//        cookie.setPath("/xx/getCookie");//指定目录下的资源可获取cookie


        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        //resp.addCookie(cookie4);


        System.out.println("----》设置cookie值成功");
    }
}
