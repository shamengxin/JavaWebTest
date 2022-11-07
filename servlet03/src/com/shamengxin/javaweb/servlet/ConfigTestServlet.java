package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * ServletConfig
 *   1. ServletConfig��ʲô��
 *      jakarta.servlet.ServletConfig
 *      ��ȻServletConfig��Servlet�淶�е�һԱ��
 *      ServletConfig��һ���ӿڡ���jakarta.servlet.Servlet��һ���ӿڡ���
 *   2. ˭ȥʵ��������ӿ��أ� WEB������ʵ����
 *      public class org.apache.catalina.core.StandardWrapperFacade implements ServletConfig {}
 *      ���ۣ�Tomcat������ʵ����ServletConfig�ӿڡ�
 *      ˼���������Tomcat����������jetty�����������ServletConfig�����ʱ�򣬻�����������
 *         ��һ��һ���������������ܺ�Tomcat��һ�����������Ƕ�ʵ����ServletConfig����淶��
 *  3. һ��Servlet��������һ��ServletConfig���󡣣�Servlet��ServletConfig������һ��һ����
 *     100��Servlet����Ӧ����100��ServletConfig����
 *  4. ServletConfig������˭�����ģ���ʲôʱ�򴴽��ģ�
 *     Tomcat��������WEB��������������ServletConfig����
 *     �ڴ���Servlet�����ʱ��ͬʱ����ServletConfig����
 *  5. ServletConfig�ӿڵ����Ǹ�ɶ�ģ���ʲô���أ�
 *      Config���ĸ����ʵ���д��
 *          Configuration
 *      ServletConfig���󱻷���Ϊ��Servlet�����������Ϣ����
 *      һ��Servlet�������һ��������Ϣ����
 *      ����Servlet�����������������Ϣ����
 *  6. ServletConfig�����е��װ�װ��ʲô��Ϣ�أ�
 *     <servlet>
 *         <servlet-name>configTest</servlet-name>
 *         <servlet-class>com.shamengxin.javaweb.servlet.ConfigTestServlet</servlet-class>
 *     </servlet>
 *     ServletConfig�����а�װ����Ϣ�ǣ�
 *         web.xml�ļ���<servlet></servlet>��ǩ��������Ϣ��
 *
 *     TomcatСè�����web.xml�ļ�����web.xml�ļ���<servlet></servlet>��ǩ�е�������Ϣ�Զ���װ��ServletConfig�����С�
 *
 *  7��ServletConfig�ӿ�������Щ������
 *      <servlet>
 *         <servlet-name>configServlet2</servlet-name>
 *         <servlet-class>com.shamengxin.javaweb.servlet.ConfigTestServlet2</servlet-class>
 *         <!--�����ǿ�������һ��Servlet����ĳ�ʶ����Ϣ��-->
 *         <init-param>
 *             <param-name>driver</param-name>
 *             <param-value>com.mysql.cj.jdbc.Driver</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>url</param-name>
 *             <param-value>jdbc:mysql://localhost:3306/shamengxin</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>root</param-name>
 *             <param-value>root</param-value>
 *         </init-param>
 *         <init-param>
 *             <param-name>password</param-name>
 *             <param-value>heyufeng</param-value>
 *         </init-param>
 *     </servlet>
 *     ����<servlet></servlet>��ǩ�е�<init-param></init-param>�ǳ�ʼ�������������ʼ��������Ϣ���Զ���Сè���װ��ServletConfig�����С�
 *
 *  8. ServletConfig�ӿ�����4��������
 *      ��1��������
 *          public String getInitParameter(String name);
 *      ��2��������
 *          public Enumeration<String> getInitParameterNames();
 *      ��3��������
 *          public ServletContext getServletContext();
 *      ��4��������
 *          public String getServletName();
 *
 *      ���ϵ�4�����������Լ���д��Servlet�൱��Ҳ����ʹ��thisȥ���á������Servlet�̳���GenericServlet��

 */
public class ConfigTestServlet extends GenericServlet {
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //��ȡServletConfig����
        ServletConfig config =this.getServletConfig();
        //����ö���
        //org.apache.catalina.core.StandardWrapperFacade@6bb47220
        out.print("ServletConfig�����ǣ�"+config);
        out.print("<br>");

        //��ȡ<servlet-name></servlet-name>
        String servletName = config.getServletName();
        out.print("<servlet-name>"+servletName+"</servlet-name>");
        out.print("<br>");

        // ͨ��ServletConfig������������������Ի�ȡ��web.xml�ļ��еĳ�ʼ������������Ϣ��
        // java.util.Enumeration<java.lang.String>	getInitParameterNames() ��ȡ���еĳ�ʼ��������name
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        //��������
        while (initParameterNames.hasMoreElements()){//�Ƿ��и���Ԫ��
            String parameterName = initParameterNames.nextElement();//ȡԪ��
            String parameterVal = config.getInitParameter(parameterName);//ͨ��name��ȡvalue
            out.print(parameterName+"="+parameterVal);
            out.print("<br>");

        }
        // java.lang.String	getInitParameter(java.lang.String name) ͨ����ʼ��������name��ȡvalue
        /*String driver = config.getInitParameter("driver");
        out.print(driver);*/
    }
}
