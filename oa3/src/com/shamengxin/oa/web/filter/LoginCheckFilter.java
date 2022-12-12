package com.shamengxin.oa.web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException,ServletException {

        /**
         * ʲô����²������أ�
         *      Ŀǰд��·���ǣ�/* ��ʾ���е����������
         *
         *      �û����� index.jsp��ʱ��������
         *      �û������ĵ�¼�ˣ������Ҫ���У��������ء�
         *      �û�Ҫȥ��¼�����Ҳ�������ء�
         *      WelComeServletҲ�������ء�
         */
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;

        //��ȡ����·��
        String servletPath = request.getServletPath();

        HttpSession session = request.getSession(false);
        /*if("/index.jsp".equals(servletPath)||"/welcome".equals(servletPath)||
                "/user/login".equals(servletPath)||"/usre/exit".equals(servletPath)
                ||(session!=null&&session.getAttribute("username")!=null)){*/

        if("/index.jsp".equals(servletPath)||"/welcome".equals(servletPath)||
                "/user/login".equals(servletPath)||"/usre/exit".equals(servletPath)
                ||(session!=null&&session.getAttribute("user")!=null)){
           //����������
            chain.doFilter(request,response);
        }else {
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }

    }

}
