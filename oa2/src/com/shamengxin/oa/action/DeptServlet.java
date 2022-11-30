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

//ģ����
@WebServlet({"/dept/list","/dept/save","/dept/edit","/dept/detail","/dept/delete","/dept/modify"})
//ģ��ƥ��
//ֻҪ����·�����ԡ�/dept����ʼ�ģ��������servlet
//@WebServlet("/dept/*")
public class DeptServlet extends HttpServlet {
    //ģ�巽��
    //��дService��������û����дdoGet����doPost��


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //��ȡservlet path
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
        //������������������
        request.setCharacterEncoding("UTF-8");
        //��ȡ���е�����
        String deptno = request.getParameter("deptno");
        String dname = request.getParameter("dname");
        String loc = request.getParameter("loc");
        //�������ݿ�ִ�и������
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
            //���³ɹ�
            //��ת�������б�ҳ�棬�������б�ҳ����ͨ��java����̬���ɵģ����Ի���Ҫ�ٴ�ִ����һ��servlet��
            //request.getRequestDispatcher("/dept/list").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            //����ʧ��
            //request.getRequestDispatcher("/error.html").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    private void doDel(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doDetail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("    <head>");
        out.print("        <meta charset='utf-8'>");
        out.print("        <title>��������</title>");
        out.print("    </head>");
        out.print("    <body>");
        out.print("        <h1>��������</h1>");
        out.print("        <hr> ");

        // ��ȡ���ű��
        // /oa/dept/detail?fdsafdsas=30
        // ��Ȼ���ύ��30�����Ƿ�������ȡ����"30"����ַ�����
        String deptno = request.getParameter("deptno");

        //�������ݿ⣬���ݲ��ű�Ų�ѯ������Ϣ
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            String sql="select dname,loc from dept where deptno=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,deptno);
            rs=ps.executeQuery();
            //��������һ��ֻ��һ����¼
            if(rs.next()){
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");

                out.print("���ű�ţ�"+deptno+"<br>");
                out.print("�������ƣ�"+dname+"<br>");
                out.print("����λ�ã�"+loc+"<br>");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(conn,ps,rs);
        }

        out.print("        <input type='button' value='����' onclick='window.history.back()'>");
        out.print("    </body>");
        out.print("</html>");
    }

    private void doEdit(HttpServletRequest request, HttpServletResponse response) throws IOException {
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

    private void doSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            //request.getRequestDispatcher("/dept/list").forward(request,response);

            // �������ʹ���ض���������ᷢһ��ȫ�µ����󡣣�
            // ������ڵ�ַ���Ϸ����������������get����
            response.sendRedirect(request.getContextPath()+"/dept/list");
        }else{
            // ����ʧ����ת������ҳ��
            //request.getRequestDispatcher("/error.html").forward(request,response);

            // ����Ҳ����ʹ���ض���
            response.sendRedirect(request.getContextPath()+"/error.html");
        }
    }

    private void doList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //��ȡӦ�õĸ�·��
        String contextPath = request.getContextPath();

        //������Ӧ�����������Լ��ַ�������ֹ��������
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("    <head>");
        out.println("        <meta charset='utf-8'>");
        out.println("        <title>�����б�ҳ��</title>");
        out.println("    <script type='text/javascript'>");
        out.println("        function del(dno){");
        out.println("            if(window.confirm('�ף�ɾ�˲��ɻָ�Ŷ��')){");
        out.println("                document.location.href='"+contextPath+"/dept/delete?deptno='+dno");
        out.println("            }");
        out.println("        }");
        out.println("    </script>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <h1 align='center'>�����б�</h1>");
        out.println("        <hr>");
        out.println("        <table border='1px' align='center' width='50%'>");
        out.println("            <tr>");
        out.println("                <th>���</th>");
        out.println("                <th>���ű��</th>");
        out.println("                <th>��������</th>");
        out.println("                <th>����</th>");
        out.println("            </tr>");
        //����һ����������

        //�������ݿ⣬��ѯ���в���
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            //��ȡ����
            conn=DBUtil.getConnection();
            //��ȡԤ��������ݿ��������
            String sql="select deptno,dname,loc from dept";
            ps=conn.prepareStatement(sql);
            //ִ��sql���
            rs=ps.executeQuery();
            //�����ѯ�����
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
                out.println("                    <a href='javascript:void(0)' onclick='del("+deptno+")' >ɾ��</a>");
                out.println("                    <a href='"+contextPath+"/dept/edit?deptno="+deptno+"'>�޸�</a>");
                out.println("                    <a href='"+contextPath+"/dept/detail?deptno="+deptno+"'>����</a>");
                out.println("                </td>");
                out.println("            </tr>");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //�ͷ���Դ
            DBUtil.close(conn,ps,rs);
        }

        //����һ����������
        out.println("        </table>");
        out.println("        <hr>");
        out.println("        <a href='"+contextPath+"/add.html'>��������</a>");
        out.println("    </body>");
        out.println("</html>");
    }
}
