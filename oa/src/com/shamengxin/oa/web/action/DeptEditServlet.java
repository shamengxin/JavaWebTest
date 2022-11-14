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
        //获取应用的根路径
        String contextPath = request.getContextPath();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("	<head>");
        out.print("		<meta charset='utf-8'>");
        out.print("		<title>修改部门</title>");
        out.print("	</head>");
        out.print("	<body>");
        out.print("		<h1>修改部门</h1>");
        out.print("		<hr>");
        out.print("		<form action='"+contextPath+"/dept/modify' method='post'>");

        //获取部门编号
        String deptno = request.getParameter("deptno");
        //连接数据库，根据部门编号查询部门信息
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select dname,loc from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs=ps.executeQuery();
            //这个结果集中只有一条记录
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                //输出网页
                out.print("部门编号<input type='text' name='deptno' value='"+deptno+"' readonly/><br>");
                out.print("部门名称<input type='text' name='dname' value='"+dname+"'/><br>");
                out.print("部门位置<input type='text' name='loc' value='"+loc+"'/><br>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        out.print("			<input type='submit' value='保存'><br>");
        out.print("		</form>");
        out.print("	</body>");
        out.print("</html>");
    }
}
