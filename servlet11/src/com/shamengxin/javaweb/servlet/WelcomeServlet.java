package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(urlPatterns = {"/welcome1","/welcome2"})
//ע�⣺��ע���������һ�����飬����������ֻ��һ��Ԫ�أ������ſ���ʡ��
//@WebServlet(urlPatterns = "/welcome")
//���value���Ժ�urlPattern����һ�£���������ָ��Servlet��ӳ��·����
//@WebServlet(value = {"/welcome1","/welcome2"})
//���ע�����������value�Ļ���������Ҳ�ǿ���ʡ�Եġ�
@WebServlet("/wel")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("��ӭѧϰservlet");
    }
}
