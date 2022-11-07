package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * ��дһ����׼ͨ�õ�Servlet��������GenericServlet
 * �Ժ����е�Servlet�඼��Ҫֱ��ʵ��Servlet�ӿ��ˡ�
 * �Ժ����е�Servlet�඼Ҫ�̳�GenericServlet�ࡣ
 * GenericServlet ����һ����������
 */

public abstract class GenericServlet implements Servlet {

    //��Ա����
    private ServletConfig config;

    /**
     * init�����е�ServletConfig������Сè�䴴���õġ�
     * ���ServletConfig����Ŀǰ��init�����Ĳ����ϣ����ھֲ�������
     * ��ôServletConfig����϶��Ժ�Ҫ��service������ʹ�ã���ô���ܱ�֤ServletConfig������service�������ܹ�ʹ���أ�
     */
    @Override
    public final void init(ServletConfig servletConfig) throws ServletException {
        //System.out.println("ServletConfig����Сè�䴴���õģ�"+servletConfig);
        this.config=servletConfig;
        //����init()����
        this.init();
    }

    /**
     * ���init�����ǹ�������д��
     */
    public void init(){

    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    /**
     *���󷽷������������á�����Ҫ���������ʵ��Servlet����
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public abstract void service(ServletRequest servletRequest, ServletResponse servletResponse)
            throws ServletException, IOException ;

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
