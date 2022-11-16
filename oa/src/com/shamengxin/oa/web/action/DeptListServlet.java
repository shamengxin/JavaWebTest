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
