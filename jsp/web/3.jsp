<%@ page import="org.w3c.dom.ls.LSOutput" %>
<%@page contentType="text/html;charset=utf-8" %>

<%
    System.out.println("hello servlet");
%>

<%
    System.out.println(f);
%>

<%--
<%!
    System.out.println("hello servlet");
%>
--%>

<%!
    //成员变量
    private String name="jackson";

    //静态代码块
    static {
        System.out.println("静态代码块执行了");
    }

    //方法
    public static void m1(){
        System.out.println("m1 method execute!");
    }
%>

<%!
    public static int f=11;
%>