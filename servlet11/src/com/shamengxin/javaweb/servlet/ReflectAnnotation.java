package com.shamengxin.javaweb.servlet;

import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception{
        //使用反射机制将类上面的注释进行解析
        //获取Class对象
        Class<?> welcomeServletClass = Class.forName("com.shamengxin.javaweb.servlet.WelcomeServlet");

        //获取这个类上面的注解对象
        //先判断这个类上面有没有这个注解对象，如果有这个注解对象，就获取该注解对象
        //boolean annotationPresent = welcomeServletClass.isAnnotationPresent(WebServlet.class);
        //System.out.println(annotationPresent);

        if(welcomeServletClass.isAnnotationPresent(WebServlet.class)){
            //获取这个类上面的注解对象
            WebServlet webServletAnnotation = welcomeServletClass.getAnnotation(WebServlet.class);
            //获取注解的value属性值
            String[] value = webServletAnnotation.value();
            for (String s : value) {
                System.out.println(s);
            }
        }
    }
}
