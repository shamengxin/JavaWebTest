package com.shamengxin.oa.bean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

public class User implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        //�û���¼��
        //USer���͵Ķ�����session�д����
        //��ȡServletContext����
        ServletContext application = event.getSession().getServletContext();

        Object onlinecount = application.getAttribute("onlinecount");
        if (onlinecount == null) {
            application.setAttribute("onlinecount",1);
        }else {
            int count=(Integer)onlinecount;
            count++;
            application.setAttribute("onlinecount",count);
        }

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        //�û��˳���
        //User���͵Ķ�����session��ɾ����
        ServletContext application = event.getSession().getServletContext();
        Integer onlinecount = (Integer) application.getAttribute("onlinecount");
        onlinecount--;
        application.setAttribute("onlinecount",onlinecount);
    }

    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
