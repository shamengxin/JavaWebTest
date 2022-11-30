package com.shamengxin.oa.utils;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBCde �Ĺ�����
 */
public class DBUtil {
    // ��̬�������������ʱִ�С�
    // ��������˳��ġ����϶��µ�˳��
    // ������Դ�ļ���
    private static ResourceBundle bundle=ResourceBundle.getBundle("resource.jdbc");
    //���������ļ�key��ȡvalue
    private static String driver=bundle.getString("driver");
    private static String url=bundle.getString("url");
    private static String user=bundle.getString("user");
    private static String password=bundle.getString("password");

    static {

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ݿ����Ӷ���
     * @return conn ���Ӷ���
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {

        //��ȡ����
        Connection conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    /**
     * �ͷ���Դ
     * @param conn ���Ӷ���
     * @param ps ���ݿ��������
     * @param rs ���������
     */
    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
