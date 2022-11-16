package com.shamengxin.javaweb.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 1��һ����ͨ��javabean
 * 2��ʲô��JavaBean��
 *   java�ǿ��ȡ�
 *   bean�Ƕ��ӡ�
 *   javabean�����ȶ���
 *   �������ɿ��ȶ���ĥ���ɣ�Ԣ����java��������һ��һ����javabean��ɵġ�
 * 3��һ��javaBeanһ�����й淶�ġ�
 *      ���޲����Ĺ��췽��
 *      ����˽�л�
 *      �����ṩseter��geter����
 *      ��дtoString()
 *      ��дhashCode+equals
 *      ʵ��java.io.Serializable�ӿڡ�
 */

public class User implements Serializable {
    private String id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
