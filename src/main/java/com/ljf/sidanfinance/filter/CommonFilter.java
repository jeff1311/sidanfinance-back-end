package com.ljf.sidanfinance.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CommonFilter", urlPatterns = "/*")
public class CommonFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 解决跨域问题
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // 响应标头指定 指定可以访问资源的URI路径
        res.setHeader("Access-Control-Allow-Origin", req.getHeader("Origin"));
        // 响应标头指定响应访问所述资源到时允许的一种或多种方法
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        // 设置 缓存可以生存的最大秒数
        res.setHeader("Access-Control-Max-Age", "3600");
        // 设置 受支持请求标头
        res.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        // 指示的请求的响应是否可以暴露于该页面。当true值返回时它可以被暴露
        res.setHeader("Access-Control-Allow-Credentials","true");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
