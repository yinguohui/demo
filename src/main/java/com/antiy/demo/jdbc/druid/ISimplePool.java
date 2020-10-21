package com.antiy.demo.jdbc.druid;

/**
 * introductions:面向接口编程
 * 抽取连接池架构的接口
 */
public interface ISimplePool {


    /**
     * 功能描述 : 获取连接
     *
     * @author ygh
     * @date 13:31
     */
    PoolConnection getConnection();

    /**
     * 功能描述 :  创建连接
     *
     * @author ygh
     * @date 13:31
     */
    void createConnection(int count);
}
