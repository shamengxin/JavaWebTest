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

        //��request����ȡ���󶨵�����
        Object obj = request.getAttribute("sysTime");

        //����������
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("request���л�ȡ��ϵͳ��ǰʱ��="+obj);
    }
}
