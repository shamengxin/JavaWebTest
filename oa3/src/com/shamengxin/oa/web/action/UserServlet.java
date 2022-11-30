package com.shamengxin.oa.web.action;

import com.shamengxin.oa.utils.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Servlet负责业务的处理
//JSP负责页面的展示
@WebServlet({"/user/login","/user/exit"})
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String contextPath = request.getServletPath();
        if("/user/login".equals(contextPath)){
            doLogin(request,response);
        }else if ("/user/exit".equals(contextPath)) {
            doExit(request,response);
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取session对象，销毁session
        HttpSession session = request.getSession(false);
        if (session!=null) {
            //手动销毁session对象
            session.invalidate();
            //跳转到登录页面
            response.sendRedirect(request.getContextPath());
        }
    }

    protected void doLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean success=false;
        //你要做一件什么事？验证用户名和密码是否正确。
        //获取用户名和密码
        //前端是这样提交的：username=admin&password=123
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //连接数据库验证用户名和密码
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn= DBUtil.getConnection();
            String sql="select * from t_user where username=? and password=?";
            //编译sql
            ps=conn.prepareStatement(sql);
            //给？传值
            ps.setString(1,username);
            ps.setString(2,password);
            //执行sql
            rs=ps.executeQuery();
            //这个结果集当中最多只有一条数据。
            if (rs.next()) {//不需要while循环
                //登录成功
                success=true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.close(conn,ps,rs);
        }
        //登录成功/失败
        if (success){
            //获取session对象（这里的要求是：必须获取到session，没有session也要新建一个session对象。）
            HttpSession session = request.getSession();//session对象一定不是null
            session.setAttribute("username",username);

            //成功，跳转到用户列表
            response.sendRedirect(request.getContextPath()+"/dept/list");
        } else {
            //失败，跳转到失败页面
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        }
    }
}
