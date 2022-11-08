package com.shamengxin.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class PostServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //��ӦһЩ���ݵ��������
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<!doctype html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <title>form get servlet</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>form get servlet</h1>");
        out.print("    </body>");
        out.print("</html>");
    }
}
