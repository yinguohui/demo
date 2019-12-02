package com.antiy.demo.jdbc.druid;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * introductions:自定义连接数据管道Bean
 * 原生的Connection上面没有复用的标记
 * 自己封装设计isBusy标记位来解决线程被占用的问题
 * 总结：这个思想就是封装思想，也就是扩展功能
 */
public class PoolConnection {
    // 表示繁忙的标志，复用的标志，线程安全
    private boolean isBusy = false;
    // 真正的管道 用来操作数据的java.sql.Connection
    private Connection connection;

    public PoolConnection(boolean isBusy, Connection connection) {
        this.isBusy = isBusy;
        this.connection = connection;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //自定义释放方法
    public void close() {
        this.isBusy = false;
    }

    //自定义查询功能
    public ResultSet queryBySql(String sql) {
        Statement sm = null;
        ResultSet rs = null;
        try {
            sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
