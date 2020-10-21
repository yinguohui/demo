package com.antiy.demo.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author ygh
 * @Description 自定义数据库连接池，配置从配置文件取
 * @Date 2019/12/2
 */
public class MyDBPool {
    private static Properties properties = new Properties();
    private List<Connection> connections = new ArrayList<>();

    //静态代码段，加载配置文件，加载驱动
    static {
        InputStream in = MyDBPool.class.getClassLoader()
                .getResourceAsStream("dbconfig.properties");
        try {
            properties.load(in);
            Class.forName(properties.getProperty("driverClassName"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 功能描述 : 初始化链接
     *
     * @author ygh
     * @date 11:06
     */
    public MyDBPool() throws SQLException {
        for (int i = 0; i < 5; i++) {
            Connection con = DriverManager.getConnection(
                    properties.getProperty("url"), properties.getProperty("username"),
                    properties.getProperty("password"));
            ItcastConnection conWapper = new ItcastConnection(con, this);
            connections.add(conWapper);
        }
    }

    public void add(Connection con) {
        connections.add(con);
    }

    public Connection getConnection() throws SQLException {
        if (connections.size() > 0) {
            return connections.remove(0);
        }
        throw new SQLException("没连接了");
    }
}
