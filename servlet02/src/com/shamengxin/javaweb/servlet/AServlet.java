package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

public class AServlet implements Servlet {
    // �޲������췽��
    public AServlet() {
        System.out.println("AServlet�޲ι��췽��ִ��l");
    }

    // ����Ա�ֶ��ṩServlet����в����Ĺ��췽��������ô����
    /*public AServlet(String s){

    }*/

    // init������Ϊ��ʼ��
    // init����ִֻ��һ��
    // ��AServlet�����һ�α�����֮��ִ�С�
    // init����ͨ������ɳ�ʼ�������ġ�
    // init������ִ�е�ʱ��AServlet�����Ѿ������������ˡ�
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("AServlet's init method execuet!");
    }

    // service�������Ǵ����û�����ĺ��ķ�����
    // ֻҪ�û�����һ������service������Ȼ��ִ��һ�Ρ�
    // ����100������service������ִ��100�Ρ�
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("AServlet's service method execuet!");
    }

    // destroy����Ҳ��ִֻ��һ�Ρ�
    // Tomcat������������AServlet����֮ǰ�����һ��destroy����
    // destroy������ִ�е�ʱ��AServlet������ڴ滹û�б����١����������١�
    // destroy�����п��Ա�д����ǰ��׼����
    // ����˵���������رյ�ʱ��AServlet��������һЩ��Դ����Щ��Դ�������������������ݿ�����
    // ��ô���رշ�������ʱ��Ҫ�ر���Щ�����ر���Щ���ݿ����ӣ���ô��Щ�ر���Դ�Ĵ���Ϳ���д��destroy�������С�
    @Override
    public void destroy() {
        System.out.println("AServlet's destroy method execuet!");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }
}
