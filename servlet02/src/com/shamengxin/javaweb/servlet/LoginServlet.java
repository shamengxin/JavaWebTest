package com.shamengxin.javaweb.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;

public class LoginServlet extends GenericServlet{

    //思考一个问题：
    //有没有一种可能，需要我在LoginServlet类重写init方法？
    //当然可能，于是乎就重写了init方法。
    /*public void init(ServletConfig config) throws ServletException{
        System.out.println("重写我自己的规则。。。。");
    }*/

    @Override
    public void init() {
        System.out.println("LoginServlet's init() method execute!");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("正在处理用户登录请求，请稍后。。。。");

        // 想在LoginServlet子类中使用ServletConfig对象怎么办？
        ServletConfig config = this.getServletConfig();
        System.out.println("service方法中是否可以获取到ServletConfig对象K？"+config);
    }
}
