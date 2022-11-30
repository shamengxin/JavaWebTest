package com.shamengxin.javaweb.servlet;

import jakarta.servlet.annotation.WebServlet;

public class ReflectAnnotation {
    public static void main(String[] args) throws Exception{
        //ʹ�÷�����ƽ��������ע�ͽ��н���
        //��ȡClass����
        Class<?> welcomeServletClass = Class.forName("com.shamengxin.javaweb.servlet.WelcomeServlet");

        //��ȡ����������ע�����
        //���ж������������û�����ע�������������ע����󣬾ͻ�ȡ��ע�����
        //boolean annotationPresent = welcomeServletClass.isAnnotationPresent(WebServlet.class);
        //System.out.println(annotationPresent);

        if(welcomeServletClass.isAnnotationPresent(WebServlet.class)){
            //��ȡ����������ע�����
            WebServlet webServletAnnotation = welcomeServletClass.getAnnotation(WebServlet.class);
            //��ȡע���value����ֵ
            String[] value = webServletAnnotation.value();
            for (String s : value) {
                System.out.println(s);
            }
        }
    }
}
