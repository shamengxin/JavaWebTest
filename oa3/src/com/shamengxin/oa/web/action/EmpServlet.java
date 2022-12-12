package com.shamengxin.oa.web.action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Ա������ġ�
 * Ա�������ǰ��Ҳ����Ҫ�ȵ�¼��
 */
public class EmpServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*//post������������
        request.setCharacterEncoding("UTF-8");
        //��Ӧ������������
        response.setContentType("text/html;charset=UTF-8");*/

        HttpSession session = request.getSession(false);
        if(session!=null&&session.getAttribute("username")!=null){
            String servletPath = request.getServletPath();
            //...
        }else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");

        }
    }
}
