package com.shamengxin.oa.web.action;

import com.shamengxin.oa.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //���ݲ��ű��ɾ������
        //��ȡ���ű��
        String deptno = request.getParameter("deptno");
        //�������ݿ�ɾ������
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="delete from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //����ֵ��Ӱ�������ݿ��ж�������Ϣ
            count=ps.executeUpdate();
            //�����ύ
            conn.commit();
        } catch (SQLException throwables) {
            //�ع�
            if(conn!=null){
                try {
                    conn.rollback();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }

        //�ж�ɾ���ɹ�����ɾ��ʧ����
        if(count==1){
            //ɾ���ɹ�
            //��ȻҪ��ת�������б�ҳ��
            //�����б�ҳ�����ʾ��Ҫִ����һ��Servlet����ô�죿ת����
            //request.getRequestDispatcher("/dept/list").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            //ɾ��ʧ��
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }

    }
}
