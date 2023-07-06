package com.example.dbemp.demos.web;

import java.sql.*;
//数据库连接工具类
public class JDBCUtils {
    /**
     * 连接数据库的操作，用户名，密码，使用jdbc连接
     */
    public static String username = "root";
    public static String password = "0914001x";
    public static String url = "jdbc:mysql://localhost:3306/emp?allowMultiQueries=true&useUnicode=true&characterEncoding=utf-8&useSSL=false";

    static {
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void CloseConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void CloseDB(ResultSet rs, PreparedStatement stm, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
