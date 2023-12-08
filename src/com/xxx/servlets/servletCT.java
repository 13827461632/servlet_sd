package com.xxx.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;


/**
 *  这里配置了 @WebServlet 注解 就不需要在 web.xml 配置servlet了
 */
//@WebServlet("/xie")
//@WebServlet(value = {"/xie","/xie001"}) //这种方式也行  2个路径都可以访问到
@WebServlet(urlPatterns = {"/xie","/xie01"}) //这种方式和上面效果一样
public class servletCT extends HttpServlet {

    @Override
    public void destroy() {
        System.out.println("服务器关闭，这个servlet销毁了（关闭服务器才会执行这个）");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求 访问 编码 ，解决乱码问题
        req.setCharacterEncoding("UTF-8");//设置请求编码
//        resp.setCharacterEncoding("UTF-8");//设置响应编码
//        resp.setHeader("Content-type","text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=UTF-8");//这种简单不用 写setCharacterEncoding setHeader 也可以达到同样的效果

        System.out.println("重写servlet...");
        //响应数据
        //getWriter 和 getOutputStream 不能同时使用（同时使用会报错）
        //字符输出流（字符串数据）
      //  resp.getWriter().write("PrintWriter访问成功...");
        //字节输出流（输出任意类型数据）(这里要加上编码 ，不然会乱码 ，就算上面定义了全局也会是乱码)
        resp.getOutputStream().write("OutputStream访问成功...".getBytes("UTF-8"));

        String url = req.getRequestURL()+"";
        System.out.println("请求全路径："+url);

        String uri  = req.getRequestURI();
        System.out.println("请求路径："+uri);

        String parm  = req.getQueryString();
        System.out.println("请求数据："+parm);

        String meth = req.getMethod();
        System.out.println("请求方式："+meth);

        String protocol = req.getProtocol();
        System.out.println("请求协议版本："+protocol);

        String contextPath = req.getContextPath();
        System.out.println("请求上下文路径："+contextPath);

        /**
         * 获取请求参数值
         */
        //获取指定参数
        String name = req.getParameter("name");
        System.out.println("请求参数name："+name);
        String age = req.getParameter("age");
        System.out.println("age："+age);

        //获取所以参数
        String[] allValue = req.getParameterValues("allValue");
        System.out.println("获取所以参数：" + allValue);
        if (allValue!=null) {
            System.out.println("获取所以参数：" + allValue.toString());
        }
        //获取请求转发的 设置的域值
        String Aname = (String) req.getAttribute("Aname");
        System.out.println("域参数Aname："+Aname);
        String Aage = (String) req.getAttribute("Aage");
        System.out.println("域参数age："+Aage);
        List<String> attrlist = (List<String>) req.getAttribute("attrlist");
        if (attrlist!=null&&!attrlist.isEmpty()){
            for (String String:attrlist) {
                System.out.println("域数组attrlist："+String);
            }
        }


    }

}
