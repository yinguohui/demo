package com.antiy.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/2
 */
public class DBUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8&serverTimezone=UTC", "root","root");
        return connection;
    }

    public static void main(String[] args) {
//        Class.forName();ClassLoader.getSystemClassLoader()
        Integer a = 1000;
        Integer b = 1000;
        Integer c = 100;
        Integer d = 100;
        System.out.println(a==b);
        System.out.println(c==d);
//        StringBuffer
    }
}
