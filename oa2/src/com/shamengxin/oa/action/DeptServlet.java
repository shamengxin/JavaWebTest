package com.shamengxin.oa.action;

import com.shamengxin.oa.util.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//模板类
@WebServlet({"/dept/list","/dept/save","/dept/edit","/dept/detail","/dept/delete","/dept/modify"})
//模糊匹配
//只要请求路径是以“/dept”开始的，都走这个servlet
//@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {
    //模板方法
    //重写Service方法（并没有重写doGet或者doPost）


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取servlet path
        String servletPath = request.getServletPath();
        if("/dept/list".equals(servletPath)){
            doList(request,response);
        }else if("/dept/save".equals(servletPath)){
            doSave(request,response);
        }else if("/dept/edit".equals(servletPath)){
            doEdit(request,response);
        }else if("/dept/detail".equals(servletPath)){
            doDetail(request,response);
        }else if("/dept/delete".equals(servletPath)){
            doDel(request,response);
        }else if("/dept/modify".equals(servletPath)){
            doModify(request,response);
        }
    }

    private void doModify(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决请求体的乱码问题
        request.setCharacterEncoding("UTF-8");
        //获取表单中的数据
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        //连接数据库执行更新语句
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            conn= DBUtil.getConnection();
            String sql="update dept set dname=?,loc=? where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,dname);
            ps.setString(2,loc);
            ps.setString(3,deptno);
            count = ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,null);
        }

        if(count==1){
            //更新成功
            //跳转到部门列表页面，（部门列表页面是通过java程序动态生成的，所以还需要再次执行另一个servlet）
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            //更新失败
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //根据部门编号删除部门
        //获取部门编号
        String deptno = request.getParameter("deptno");
        //连接数据库删除数据
        Connection conn=null;
        PreparedStatement ps=null;
        int count=0;
        try {
            conn= DBUtil.getConnection();
            conn.setAutoCommit(false);
            String sql="delete from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            //返回值是影响了数据库中多少条信息
            count=ps.executeUpdate();
            //事务提交
            conn.commit();
        } catch (SQLException throwables) {
            //回滚
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

        //判断删除成功还是删除失败了
        if(count==1){
            //删除成功
            //仍然要跳转到部门列表页面
            //部门列表页面的显示需要执行另一个Servlet。怎么办？转发。
            //request.getRequestDispatcher("/dept/list").forward(request, response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            //删除失败
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }

    }

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>部门详情</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>部门详情</h1>");
        out.print("        <hr> ");

        // 获取部门编号
        // /oa/dept/detail?fdsafdsas=30
        // 虽然是提交的30，但是服务器获取的是"30"这个字符串。
        String deptno = request.getParameter("deptno");

        //连接数据库，根据部门编号查询部门信息
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            String sql="select dname,loc from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs=ps.executeQuery();
            //这个结果集一定只有一条记录
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("部门编号："+deptno+"<br>");
                out.print("部门名称："+dname+"<br>");
                out.print("部门位置："+loc+"<br>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        out.print("        <input type='button' value='后退' onclick='window.history.back()'>");
        out.print("    </body>");
        out.print("</html>");
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取部门信息
        // 注意乱码问题（Tomcat10不会出现这个问题）
        request.setCharacterEncoding("UTF-8");
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        // 连接数据库执行insert语句
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
            // 保存成功跳转到列表页面
            //转发是一次请求
            //request.getRequestDispatcher("/dept/list").forward(request,response);

            // 这里最好使用重定向（浏览器会发一次全新的请求。）
            // 浏览器在地址栏上发送请求，这个请求是get请求。
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            // 保存失败跳转到错误页面
            //request.getRequestDispatcher("/error.html").forward(request,response);

            // 这里也建议使用重定向。
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
