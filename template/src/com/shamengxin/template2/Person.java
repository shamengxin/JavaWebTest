package com.shamengxin.template2;

/**
 * Teacher��Student����Person
 * 1. Person����ģ�巽�����ģʽ���е�ģ���ࡣ
 * 2. day()��������ģ�巽�����ģʽ���е�ģ�巽����
 */
public abstract class Person {
    // ģ�巽��
    // �����final֮����������޷������ǣ��������ĵ��㷨Ҳ���Եõ�������
    // ģ�巽��������ĵ��㷨�Ǽܣ������ʵ�ֲ�������ӳٵ����൱��ȥʵ�֡�
    // �����㷨һ�����ǵõ��˱��������ܱ��ı䡣����һ��������㷨�õ����ظ�ʹ�á�
    // �������Ҳ�õ��˷��ã���Ϊ�㷨��ĳЩ����Ĵ����ǹ̶��ġ���Щ�̶��Ĵ��벻����������ı仯���任����һ���ִ������д��ģ���൱�С�
    public final void day(){
        // ��һ��
        qiChuang();
        // �ڶ���
        xiShu();
        // ������
        chiZaoCan();
        // ���Ĳ�
        doSome();
        // ���岽
        chiWanFan();
        // ������
        shuiJiao();
    }

    // ���е�ĳЩ���裬������������ı仯���仯����Щ�������д�������У��õ����븴�á�
    public void qiChuang(){
        System.out.println("��");
    }

    public void xiShu(){
        System.out.println("ϴ��");
    }

    public void chiZaoCan(){
        System.out.println("�����");
    }

    // ��һ����Ҫ�������Ǿ�����һ����ô��������˵���㡣
    public abstract void doSome();

    public void chiWanFan(){
        System.out.println("����");
    }

    public void shuiJiao(){
        System.out.println("˯��");
    }
}
