package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    //ͨ���޲������췽����������
    /*public HelloServlet(){

    }*/

    // û���ṩinit��������ô��Ȼִ�и���HttpServlet��init������
    // HttpServlet����û��init�����������ִ��GenericServlet���е�init������

    // û���ṩservice��������ô��Ȼִ�и���HttpServlet��service������


    /*@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<h1>hello servlet</h1>");

    }*/

    // ��ǰ�˷��͵�������get�����ʱ����������дdoGet������

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>doGet<h1>");
    }

    // ��ǰ�˷��͵�������post�����ʱ����������дdoPost����

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>doPost<h1>");
    }
}
