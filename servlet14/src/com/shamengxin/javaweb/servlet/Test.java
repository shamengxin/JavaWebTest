package com.shamengxin.javaweb.servlet;

/**
 * �����������⣺
 *  �ڱ���׶��Ѿ���ȫȷ���˵��ù�ϵ��
 *  �������ı����ǵĵ���˳�򣬱����޸�����javaԴ���롣
 *  java�����޸ģ���Ҫ���±��룬��Ŀ��Ҫ���²��ԣ���Ŀ��Ҫ���·���������һ�������Ĺ��̡�
 *  ��Ȼ���������ģʽΥ���ˣ�OCPԭ�򡣣�����ԭ��
 *
 *  ����ԭ�򣺶���չ���ţ����޸Ĺرա�
 *          ����Ŀ��չ��û���������������չ�Ĺ���������޸�����֮ǰд�õĴ��룬���������Ĳ����ˡ�
 *          ���Ҫ�ﵽ��Ч���ǣ�������չ��������ñ����֮ǰд�õĴ���
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("main begin");
        m1();
        System.out.println("main over");
    }

    private static void m1() {
        System.out.println("m1 begin");
        m2();
        System.out.println("m1 over");
    }

    private static void m2() {
        System.out.println("m2 begin");
        m3();
        System.out.println("m2 over");
    }

    private static void m3() {
        System.out.println("Ŀ������ִ���С���������");
    }
}
