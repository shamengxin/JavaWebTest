package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class UserSaveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String realname = request.getParameter("realname");
        System.out.println(realname);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //������������ַ���
        request.setCharacterEncoding("UTF-8");

        //��ȡ�û��ύ���û���
        String username = request.getParameter("username");
        //���username
        System.out.println(username);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("��Һã�����һ��java����ʦ��");
    }
}
