package com.antiy.demo.jdbc;


import com.mysql.cj.jdbc.ConnectionWrapper;
import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.MysqlPooledConnection;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/2
 */
public class ItcastConnection extends ConnectionWrapper {
    private MyDBPool pool;

    public ItcastConnection(Connection connection, MyDBPool pool) throws SQLException {
        super(new MysqlPooledConnection((JdbcConnection) connection), (JdbcConnection) connection, false);
        this.pool = pool;
    }

    @Override
    public void close() throws SQLException {
        pool.add(this);
    }
}