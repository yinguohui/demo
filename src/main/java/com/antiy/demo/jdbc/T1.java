package com.antiy.demo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/2
 */
public class T1 {
    public static void main(String[] args) {
        try {
            Connection connection = DBUtil.getConnection();
            Statement statement = connection.createStatement();
            String sql = "insert into user (id,name,age,role) values (2,'小明',11,1)";
            //在statement中使用字符串拼接的方式，这种方式存在诸多问题
            statement.execute(sql);
            System.out.println("执行完毕");
            connection.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
