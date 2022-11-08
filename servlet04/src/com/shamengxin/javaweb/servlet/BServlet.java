package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;

public class BServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //��ȡServletContext����
        ServletContext application = this.getServletContext();
        out.print("ServletContext�����ǣ�" + application + "<br>");

        //ȡ����
        Object userObj = application.getAttribute("userObj");
        //����������
        out.print(userObj+"<br>");

        //log
        //�����־���Զ���¼�������أ�
        // CATALINA_HOME/logsĿ¼��
        application.log("��Һã�����shamengxin");

        int age=17;//17��
        //������С��18���ʱ�򣬱�ʾ�Ƿ�����¼��־
        if(age<18){
            application.log("�Բ���δ���꣬�����У�",new RuntimeException("���ʺϣ�"));
        }
    }
}

