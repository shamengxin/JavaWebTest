package com.shamengxin.oa.web.action;

import com.shamengxin.oa.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //��ȡ������Ϣ
        // ע���������⣨Tomcat10�������������⣩
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        // �������ݿ�ִ��insert���
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            conn=DBUtil.getConnection();
            String sql="insert into dept(deptno,dname,loc)values(?,?,?)";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            ps.setString(2,dname);
            ps.setString(3,loc);
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }

        if(count==1){
            // ����ɹ���ת���б�ҳ��
            //ת����һ������
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else{
            // ����ʧ����ת������ҳ��
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
