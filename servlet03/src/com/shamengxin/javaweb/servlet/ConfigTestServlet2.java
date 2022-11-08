package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class ConfigTestServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //��ȡServletConfig����
        ServletConfig config=this.getServletConfig();

        //����ö���
        //org.apache.catalina.core.StandardWrapperFacade@6991a4c9
        out.print("ServletConfig�����ǣ�"+config);

        String value = config.getInitParameter("key");
        out.print("<br>"+value);
    }
}
