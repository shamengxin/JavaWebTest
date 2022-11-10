package com.shamengxin.javaweb.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取系统当前时间
        Date nowTime=new Date();

        //向request域当中绑定数据
        request.setAttribute("sysTime",nowTime);

        //从request域当中取出绑定的数据
        //Object obj = request.getAttribute("sysTime");

        //输出到浏览器
        /*
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("request域中获取的系统当前时间="+obj);
         */

        //可以这样做吗？
        //在AServlet当中new一个BServlet对象，然后调用BServlet对象的doGet方法，把request对象传过去
        //这个代码虽然可以实现功能，但是Servlet对象不能由程序员来new，自己new的Servlet对象声明周期不受Tomcat服务器管理
        /*BServlet bServlet=new BServlet();
        bServlet.doGet(request,response);*/

        // 通过AServlet能不能跳转到BServlet
        // 让AServlet和BServlet放到一次请求当中。
        // 可以的。使用Servlet当中请求转发机制.(资源转发可以使用转发机制来完成）
        //怎么转发？代码怎么写？
        //第一步，获取请求转发器对象
        //相当于把"/b"这个路径包装到请求转发器当中，实际上是把下一个资源的路径告知给Tomcat服务器了。
        //RequestDispatcher requestDispatcher = request.getRequestDispatcher("/b");

        //第二步：调用请求转发器RequestDispatcher的forward方法，进行转发
        //转发的时候：这两个参数很重要。request和response都是要传递给下一个资源的
        //requestDispatcher.forward(request,response);

        //一行代码搞定转发
        //request.getRequestDispatcher("/b").forward(request,response);

        //转发到一个servlet，也可以转发到一个html，只要是WEB容器中的合法资源即可。
        request.getRequestDispatcher("/test.html").forward(request,response);

    }
}
