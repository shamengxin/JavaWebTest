package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //���������е���ȡ���洢������
        Object userObj = request.getAttribute("userObj");

        //����������
        response.setContentType("text/html;chatset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("�������е��û�����"+userObj);
    }
}
