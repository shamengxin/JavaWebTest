package com.shamengxin.javaweb.servlet;

import com.shamengxin.javaweb.bean.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //����һ���û�����
        User user=new User();
        user.setId("1111");
        user.setName("�ܿ�");

        //���û�����洢����������
        request.setAttribute("userObj",user);

        //ת��
        //request.getRequestDispatcher("/b").forward(request,response);

        //�ض������¶�����
        // �ض���ʱ��·��������Ҫ����Ŀ����ʼ������˵��Ҫ�����Ŀ����
        // response�������·����"/servlet10/b"��Ӧ��������ˡ�
        // ��������Է����������������һ��ȫ�µ�����http://localhost:8080/servlet10/b
        // ���������һ����������������
        // ��һ������http://localhost:8080/servlet10/a
        // �ڶ�������http://localhost:8080/servlet10/b
        // �����������ַ������ʾ�ĵ�ַ��Ȼ�������һ������ĵ�ַ�������ض���ᵼ���������ַ���ϵĵ�ַ�����ı䡣
        response.sendRedirect(request.getContextPath()+"/b");
    }
}
