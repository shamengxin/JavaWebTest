package com.shamengxin.javaweb.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/abc")
//@WebFilter("/a.do")
//@WebFilter({"/a.do","/b.do"})

/*�������·������ģ��ƥ���е���չƥ�䡣���Ǻſ�ʼ��ע������·����Ҫ��/��ʼ��*/
@WebFilter("*.do")

/*����ǰ׺ƥ�䣬Ҫ��/��ʼ��*/
//@WebFilter("/dept/*)

//ƥ������·��
//@WebFilter("/*")
public class Filter1 implements Filter {

    /*public Filter1(){
        System.out.println("�޲������췽��ִ��");
    }*/

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init����ִ��");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        //�������ʱ����ӹ��˹���
        System.out.println("doFilter������ʼִ��");
        //ִ����һ���������������һ�����ǹ������ˣ���ִ��Ŀ�����Servelet��
        //�����ߣ�û�����ǲ��еΡ�
        chain.doFilter(request,response);

        //����Ӧ��ʱ����ӹ��˹���
        System.out.println("doFilter����ִ�н���");
    }

    @Override
    public void destroy() {
        System.out.println("destroy����ִ��");
    }
}
