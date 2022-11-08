package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletContext
 * 1. ServletContext��ʲô��
 *  ServletContext�ǽӿڣ���Servlet�淶�е�һԱ��
 * 2. ServletContext��˭ʵ�ֵģ�
 *  Tomcat��������WEB��������ʵ����ServletContext�ӿڡ�
 *  public class org.apache.catalina.core.ApplicationContextFacade implements ServletContext {}
 * 3. ServletContext������˭�����ģ���ʲôʱ�򴴽��ģ�
 *  ServletContext������WEB������������ʱ�򴴽���
 *  ServletContext������WEB�����������ġ�
 *  ����һ��webapp��˵��ServletContext����ֻ��һ����
 *  ServletContext�����ڷ������رյ�ʱ�����١�
 * 4. ServletContext��ô��⣿
 *  context��ʲô��˼��
 *      Servlet����Ļ������󡣣�Servlet����������Ķ��󡣣�
 *  ServletContext������ʵ��Ӧ�ľ�������web.xml�ļ���
 *  50��ѧ����ÿ��ѧ������һ��Servlet����50��ѧ������ͬһ�����ҵ��С���ô������Ҿ��൱��ServletContext����
 *  ����ServletContext�����е����ݣ�����Servletһ���ǹ���ġ�
 *  ���磺һ�������еĿյ�������ѧ������ģ�һ�������е�������ʦ������ѧ������ġ�
 *  Tomcat��һ��������һ���������п��ԷŶ��webapp��һ��webapp��Ӧһ��ServletContext����
 */

public class AServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        //��ȡServletContext����
        ServletContext application = this.getServletContext();
        out.print("ServletContext�����ǣ�" + application + "<br>");

        //��ȡ�����ĵĳ�ʼ������
        Enumeration<String> initParameterNames = application.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String name = initParameterNames.nextElement();
            String value = application.getInitParameter(name);
            out.print(name+"="+value+"<br>");
        }

        //��ȡcontext path ����ȡӦ�������ĵĸ���
        String contextPath = application.getContextPath();
        out.print(contextPath+"<br>");

       //��ȡ�ļ��ľ���·��
        //String realPath = application.getRealPath("/index.html");//����
        //String realPath = application.getRealPath("index.html");//���ӡ�/"Ҳ����
        //out.print(realPath+"<br>");

        String realPath = application.getRealPath("/common/common.html");
        out.print(realPath+"<br>");

        //��ServletContextӦ�����д洢����
        User user = new User("jack","123");
        //��ServletContextӦ�����д洢����
        application.setAttribute("userObj", user);
        //ȡ����
        //Object userObj = application.getAttribute("userObj");
        //����������
        //out.print(userObj+"<br>");
    }
}
