package com.shamengxin.javaweb.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    //��session���д洢���ݵ�ʱ�����·�����web����������
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session add");
    }

    //��session���д洢������ɾ����ʱ�����·�����WEB����������
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session remove");
    }

    //��session���е�ĳ�����ݱ��滻��ʱ���ʱ�����·�����WEB����������
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session replace");
    }
}
