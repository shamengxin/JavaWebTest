package com.shamengxin.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡϵͳ��ǰʱ��
        Date nowTime=new Date();

        //��request���а�����
        request.setAttribute("sysTime",nowTime);

        //��request����ȡ���󶨵�����
        //Object obj = request.getAttribute("sysTime");

        //����������
        /*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("request���л�ȡ��ϵͳ��ǰʱ��="+obj);
         */

        //������������
        //��AServlet����newһ��BServlet����Ȼ�����BServlet�����doGet��������request���󴫹�ȥ
        //���������Ȼ����ʵ�ֹ��ܣ�����Servlet�������ɳ���Ա��new���Լ�new��Servlet�����������ڲ���Tomcat����������
        /*BServlet bServlet=new BServlet();
        bServlet.doGet(request,response);*/

        // ͨ��AServlet�ܲ�����ת��BServlet
        // ��AServlet��BServlet�ŵ�һ�������С�
        // ���Եġ�ʹ��Servlet��������ת������.(��Դת������ʹ��ת����������ɣ�
        //��ôת����������ôд��
        //��һ������ȡ����ת��������
        //�൱�ڰ�"/b"���·����װ������ת�������У�ʵ�����ǰ���һ����Դ��·����֪��Tomcat�������ˡ�
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/b");

        //�ڶ�������������ת����RequestDispatcher��forward����������ת��
        //ת����ʱ����������������Ҫ��request��response����Ҫ���ݸ���һ����Դ��
        //requestDispatcher.forward(request,response);

        //һ�д���㶨ת��
        //request.getRequestDispatcher("/b").forward(request,response);

        //ת����һ��servlet��Ҳ����ת����һ��html��ֻҪ��WEB�����еĺϷ���Դ���ɡ�
        request.getRequestDispatcher("/test.html").forward(request,response);

    }
}
