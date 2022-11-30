package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet({"/test/session"})
public class TestSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request对象代表了一次请求。（一次请求对应一request对象，两次请求对应两个不同的request对象。）
        //session对象代表了一次会话。（一次会话对应一个session对象。）
        //获取session对象
        HttpSession session = request.getSession();

        //向会话域中绑定数据。
        //session.getAttribute();
        //从会话域当中取数据。
        //Object obj = session.getAttribute();


        //将session对象响应到浏览器。
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("会话对象："+session);//想看看对象的内存地址。
    }
}
