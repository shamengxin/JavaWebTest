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

        //��ȡ�ͻ��˵�ip��ַ
        /*String remoteAddr = request.getRemoteAddr();
        System.out.println("�ͻ��˵�ip��ַ��"+remoteAddr);*/

        //�������ʹ�ý϶ࣨ��̬��ȡӦ�õĸ�·����
        String contextPath = request.getContextPath();
        System.out.println("Ӧ�õĸ�·����"+contextPath);

        //��ȡ����ʽ
        String method = request.getMethod();
        System.out.println(method);

        //��ȡ�����URI
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);

        //��ȡservlet·��
        String servletPath = request.getServletPath();
        System.out.println(servletPath);
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }*/
}
