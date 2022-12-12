package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session/attribute/test")
public class HttpSessionAttributeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //��ȡsession����
        HttpSession session = request.getSession();

        //��session���д洢����
        session.setAttribute("user","zhangsan");

        //�滻
        session.setAttribute("user","lisi");

        //ɾ��
        session.removeAttribute("user");
    }
}
