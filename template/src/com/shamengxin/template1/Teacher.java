package com.shamengxin.template1;
/**
 * ���ڵ����⣺
 *      ��һ���㷨û�еõ��ظ���ʹ�á�
 *      �ڶ�������û�еõ����á�
 */
public class Teacher {
    /**
     *�������������ʦ��һ��
     */
    public void day(){
        // ��Teacher���㷨��ͬ��
        qiChuang();
        xiShu();
        chiZaoCan();
        doSome();
        chiWanFan();
        shuiJiao();
    }

    public void qiChuang(){
        System.out.println("��");
    }

    public void xiShu(){
        System.out.println("ϴ��");
    }

    public void chiZaoCan(){
        System.out.println("�����");
    }

    public void doSome(){
        System.out.println("��ʦ���ڿ������ڿΣ�����ѧ��֪ʶ");
    }

    public void chiWanFan(){
        System.out.println("����");
    }

    public void shuiJiao(){
        System.out.println("˯��");
    }
}
