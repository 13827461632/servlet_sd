package com.xxx.filter;



import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter("/sfilter")
public class filterCT implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----->开始进入过滤器"); //启动服务就会初始化  init方法
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //设置 解决响应乱码问题
        System.out.println("过滤成功--->开始设置响应乱码");
        servletResponse.setContentType("text/html;charset=UTF-8");
        //拦截后这段码必须些 不然请求到不了 servlet
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("--->回来过滤器--->");

    }


    @Override
    public void destroy() {

        System.out.println("----->销毁过滤器"); //跟servlet 一样 关闭应用销毁

    }
}
