package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class RequestTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //org.apache.catalina.connector.RequestFacade@50e10b7f
        out.print(request);

        //获取客户端的ip地址
        /*String remoteAddr = request.getRemoteAddr();
        System.out.println("客户端的ip地址："+remoteAddr);*/

        //这个方法使用较多（动态获取应用的根路径）
        String contextPath = request.getContextPath();
        System.out.println("应用的根路径："+contextPath);

        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);

        //获取请求的URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        //获取servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }*/
}
