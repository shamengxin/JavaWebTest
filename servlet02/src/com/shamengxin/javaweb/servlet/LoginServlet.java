package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet{

    //˼��һ�����⣺
    //��û��һ�ֿ��ܣ���Ҫ����LoginServlet����дinit������
    //��Ȼ���ܣ����Ǻ�����д��init������
    /*public void init(ServletConfig config) throws ServletException{
        System.out.println("��д���Լ��Ĺ��򡣡�����");
    }*/

    @Override
    public void init() {
        System.out.println("LoginServlet's init() method execute!");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("���ڴ����û���¼�������Ժ󡣡�����");

        // ����LoginServlet������ʹ��ServletConfig������ô�죿
        ServletConfig config = this.getServletConfig();
        System.out.println("service�������Ƿ���Ի�ȡ��ServletConfig����K��"+config);
    }
}
