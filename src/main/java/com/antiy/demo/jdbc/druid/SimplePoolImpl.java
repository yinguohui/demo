package com.antiy.demo.jdbc.druid;

import com.antiy.demo.jdbc.util.PropertiesUtil;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Vector;

/*
 * introductions:线程池的实现类，实现管道的配置、初始化、创建和提供
 * created by Heylink on 2018/4/27 18:31
 */
public class SimplePoolImpl implements ISimplePool {

    //jdbc参数
    private static String jdbcDriver = null;
    private static String jdbcUrl = null;
    private static String username = null;
    private static String password = null;
    //限制连接池中的管道数量参数
    private static int initCount = 3;
    private static int stepSize = 10;
    private static int poolMaxSize = 150;
    private static Vector<PoolConnection> poolConnections = new Vector<>();

    public SimplePoolImpl() {
        init();
    }

    private void init() {
        //1.外部配置文件的读取
        jdbcDriver = PropertiesUtil.getProperty("jdbcDriver");
        jdbcUrl = PropertiesUtil.getProperty("jdbcUrl");
        username = PropertiesUtil.getProperty("username");
        password = PropertiesUtil.getProperty("password");
        //2.限制管道数量参数初始化
        if (Integer.valueOf(Objects.requireNonNull(PropertiesUtil.getProperty("initCount"))) > 0) {
            initCount = Integer.valueOf(PropertiesUtil.getProperty("initCount"));
        }
        if (Integer.valueOf(Objects.requireNonNull(PropertiesUtil.getProperty("stepSize"))) > 0) {
            stepSize = Integer.valueOf(PropertiesUtil.getProperty("stepSize"));
        }
        if (Integer.valueOf(Objects.requireNonNull(PropertiesUtil.getProperty("poolMaxSize"))) > 0) {
            poolMaxSize = Integer.valueOf(PropertiesUtil.getProperty("poolMaxSize"));
        }
        //3.DriverManager 管家用来注册，驱动实例
        try {
            //获取数据库的驱动对象
            Driver dbDriver = (Driver) Class.forName(jdbcDriver).newInstance();
            DriverManager.registerDriver(dbDriver);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //4.初始化连接池中的管道数量
        createConnection(initCount);
    }

    /**
     * 对外提供管道
     * @author heylinlook
     * @date 2018/4/27 20:20
     * @param
     * @return
     */
    @Override
    public PoolConnection getConnection() {
        if (poolConnections.size() == 0) {
            System.out.println("连接池还未初始化，将执行初始化操作");
            createConnection(initCount);
        }
        PoolConnection connection = getRealConnection();
        //多线程环境中 线程拿到对象 引用堆当中实例 可能被其他线程抢走或者线程终止导致管道为空
        while (connection == null) {
            //管道被抢，扩容
            createConnection(stepSize);
            //再次获取有效管道
            connection = getRealConnection();
            try {
                //个人经验：人为的减少竞争 醒来后仍然判断是否为空
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //返回有效对象
        return connection;
    }

    /**
     * 获取有效的管道 加锁
     * 1.管道对象长期在集合中，没有超时回收
     * 2.没有被其他线程占用
     * @author heylinlook
     * @date 2018/4/27 20:23
     * @param
     * @return
     */
    private synchronized PoolConnection getRealConnection() {
        for (PoolConnection conn : poolConnections) {
            if (!conn.isBusy()) {
                //没有被占用的情况
                Connection connection = conn.getConnection();
                //进一步判断是否没有长期存在集合中被回收
                try {
                    //如果失效
                    if (!connection.isValid(2000)) {
                        //替换 保证最大效率(不走create方法)
                        connection = DriverManager.getConnection(jdbcUrl, username, password);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                //当前线程占用该管道
                conn.setBusy(true);
                return conn;
            }
        }
        //如果遍历完都没有有效的管道，返回空
        return null;
    }

    @Override
    public void createConnection(int count) {
        //判断是否还可以再增加管道数量
        if (poolMaxSize <= 0 || poolMaxSize < (poolConnections.size() + count)) {
            return;
        }
        //添加count个管道
        for (int i = 0; i < count; i++) {
            try {
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
                //封装管道
                PoolConnection poolConnection = new PoolConnection(false, connection);
                //添加到vector
                poolConnections.add(poolConnection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
