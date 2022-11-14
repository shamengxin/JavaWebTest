package com.shamengxin.oa.web.action;

import com.shamengxin.oa.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeptEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //��ȡӦ�õĸ�·��
        String contextPath = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("	<head>");
        out.print("		<meta charset='utf-8'>");
        out.print("		<title>�޸Ĳ���</title>");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1>�޸Ĳ���</h1>");
        out.print("		<hr>");
        out.print("		<form action='"+contextPath+"/dept/modify' method='post'>");

        //��ȡ���ű��
        String deptno = request.getParameter("deptno");
        //�������ݿ⣬���ݲ��ű�Ų�ѯ������Ϣ
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select dname,loc from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs=ps.executeQuery();
            //����������ֻ��һ����¼
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //�����ҳ
                out.print("���ű��<input type='text' name='deptno' value='"+deptno+"' readonly/><br>");
                out.print("��������<input type='text' name='dname' value='"+dname+"'/><br>");
                out.print("����λ��<input type='text' name='loc' value='"+loc+"'/><br>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        out.print("			<input type='submit' value='����'><br>");
        out.print("		</form>");
        out.print("	</body>");
        out.print("</html>");
    }
}
