package com.shamengxin.javaweb.servlet;

import com.shamengxin.javaweb.util.Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //����ѧ����Ϣ�����ݿ�
        request.setCharacterEncoding("UTF-8");
        String no =request.getParameter("no");
        String name = request.getParameter("name");
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            conn= Util.getConnection();
            String sql="insert into t_student(no,name) values(?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,no);
            ps.setString(2,name);
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            Util.close(conn,ps,null);
        }
        //����ɹ�֮����ת���ɹ�ҳ��
        if(count==1){
            //request.getRequestDispatcher("/success.html").forward(request,response);
            //�ض���
            response.sendRedirect(request.getContextPath()+"/success.html");
        }else{
            //request.getRequestDispatcher("/error.html").forward(request,response);
            //�ض���
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }
}
