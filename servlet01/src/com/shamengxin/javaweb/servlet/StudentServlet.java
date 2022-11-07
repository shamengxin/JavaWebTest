package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class StudentServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response)
            throws ServletException, IOException {
        //������Ӧ����������
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        //�������ݿ⣨JDBC��
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //ע������
            Class.forName("com.mysql.cj.jdbc.Driver");
            //��ȡ����
            String url="jdbc:mysql://localhost:3306/shamengxin";
            String user="root";
            String password="heyufeng";
            conn=DriverManager.getConnection(url,user,password);
            //��ȡ���ݿ��������
            String sql="select no,name from t_student";
            ps=conn.prepareStatement(sql);
            //ִ��sql
            rs=ps.executeQuery();
            //�����ѯ�����
            while (rs.next()){
                String no=rs.getString("no");
                String name=rs.getString("name");
                out.print(no+","+name+"<br>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally{
            //�ͷ���Դ
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
