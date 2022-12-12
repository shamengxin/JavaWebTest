package com.shamengxin.javaweb.listener;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("session��������");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session��������");
    }
}
