package com.shamengxin.javaweb.servlet;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class GetServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        //响应一些内容到浏览器上
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!doctype html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <title>form get servlet</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1>form get servlet</h1>");
        out.println("    </body>");
        out.println("</html>");
    }
}
