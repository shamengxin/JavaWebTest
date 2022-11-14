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

public class DeptModifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            request.getRequestDispatcher("/dept/list").forward(request,response);
        }else{
            //更新失败
            request.getRequestDispatcher("/error.html").forward(request,response);
        }
    }
}
