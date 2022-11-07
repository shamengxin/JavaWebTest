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
        //设置响应的内容类型
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        //连接数据库（JDBC）
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url="jdbc:mysql://localhost:3306/shamengxin";
            String user="root";
            String password="heyufeng";
            conn=DriverManager.getConnection(url,user,password);
            //获取数据库操作对象
            String sql="select no,name from t_student";
            ps=conn.prepareStatement(sql);
            //执行sql
            rs=ps.executeQuery();
            //处理查询结果集
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
            //释放资源
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
