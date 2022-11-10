package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从request域当中取出绑定的数据
        Object obj = request.getAttribute("sysTime");

        //输出到浏览器
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("request域中获取的系统当前时间="+obj);
    }
}
