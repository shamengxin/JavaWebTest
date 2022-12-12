package com.shamengxin.javaweb.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionAttributeListener;
import jakarta.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    //向session域当中存储数据的时候，以下方法被web服务器调用
    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        System.out.println("session add");
    }

    //将session域当中存储的数据删除的时候，以下方法被WEB服务器调用
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        System.out.println("session remove");
    }

    //将session域当中的某个数据被替换的时候的时候，以下方法被WEB服务器调用
    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        System.out.println("session replace");
    }
}
