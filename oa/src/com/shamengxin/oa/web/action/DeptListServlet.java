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

public class DeptListServlet extends HttpServlet {

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取应用的根路径
        String contextPath = request.getContextPath();

        //设置响应的内容类型以及字符集，防止乱码问题
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset='utf-8'>");
        out.println("        <title>部门列表页面</title>");
        out.println("    <script type='text/javascript'>");
        out.println("        function del(dno){");
        out.println("            if(window.confirm('亲，删了不可恢复哦！')){");
        out.println("                document.location.href='"+contextPath+"/dept/delete?deptno='+dno");
        out.println("            }");
        out.println("        }");
        out.println("    </script>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1 align='center'>部门列表</h1>");
        out.println("        <hr>");
        out.println("        <table border='1px' align='center' width='50%'>");
        out.println("            <tr>");
        out.println("                <th>序号</th>");
        out.println("                <th>部门编号</th>");
        out.println("                <th>部门名称</th>");
        out.println("                <th>操作</th>");
        out.println("            </tr>");
        //上面一部分是死的

        //连接数据库，查询所有部门
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //获取连接
            conn=DBUtil.getConnection();
            //获取预编译的数据库操作对象
            String sql="select deptno,dname,loc from dept";
            ps=conn.prepareStatement(sql);
            //执行sql语句
            rs=ps.executeQuery();
            //处理查询结果集
            int i=0;
            while (rs.next()){
                String deptno=rs.getString("deptno");
                String dname=rs.getString("dname");
                String loc=rs.getString("loc");

                out.println("            <tr>");
                out.println("                <td>"+(++i)+"</td>");
                out.println("                <td>"+deptno+"</td>");
                out.println("                <td>"+dname+"</td>");
                out.println("                <td>");
                out.println("                    <a href='javascript:void(0)' onclick='del("+deptno+")' >删除</a>");
                out.println("                    <a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>修改</a>");
                out.println("                    <a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>详情</a>");
                out.println("                </td>");
                out.println("            </tr>");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //释放资源
            DBUtil.close(conn,ps,rs);
        }

        //下面一部分是死的
        out.println("        </table>");
        out.println("        <hr>");
        out.println("        <a href='"+contextPath+"/add.html'>新增部门</a>");
        out.println("    </body>");
        out.println("</html>");

    }
}
