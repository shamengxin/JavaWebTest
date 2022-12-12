package com.shamengxin.javaweb.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletRequestListener implements ServletRequestListener {
    //request��������ʱ���
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request����������");
    }

    //request���󴴽�ʱ���
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request�����ʼ����");
    }
}
