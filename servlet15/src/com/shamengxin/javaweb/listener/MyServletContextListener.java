package com.shamengxin.javaweb.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

//ServletContextListener��������Ҫ�������ǣ�ServletContext�����״̬��
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * �������еķ�������Ҫ����Ա�ֶ����ã��Ƿ���Ī�������¼�֮�󱻷��������á�
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {//����������ʱ��㣬�������ʱ��ִ��һ�δ��룬д�����ˡ�
        //������������ʱ��д���룬��д�����ˡ����ᱻ�������Զ����á�
        //�����������ServletContext���󱻴���ʱ����á�
        System.out.println("ServeltContext���󴴽��ˡ�");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {//�������ر�ʱ���
        //������������ʱ��д���룬��д�����ˡ����ᱻ�������Զ����á�
        //�����������ServletContext�������ٵ�ʱ����á�
        System.out.println("ServletContext���������ˡ�");
    }
}
