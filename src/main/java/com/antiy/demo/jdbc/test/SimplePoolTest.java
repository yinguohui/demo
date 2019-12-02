package com.antiy.demo.jdbc.test;

import com.antiy.demo.jdbc.druid.PoolConnection;
import com.antiy.demo.jdbc.druid.PoolManager;
import com.antiy.demo.jdbc.druid.SimplePoolImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 功能描述 :
 * @author ygh
 * @date 13:41
 */
public class SimplePoolTest {
    //拿到连接池对象
    private static SimplePoolImpl simplePool = PoolManager.getInstance();

    /**
     * 单个线程使用连接池对象做查询业务
     * @author heylinlook
     * @date 2018/4/27 21:01
     * @param
     * @return
     */
    public synchronized static void selectData() {
        PoolConnection connection = simplePool.getConnection();
        //数据库中存放了测试表
        ResultSet rs = connection.queryBySql("SELECT * FROM items");
        System.out.println("线程名称： " + Thread.currentThread().getName());
        try {
            while (rs.next()) {
                System.out.print(rs.getString("ID") + "\t\t");
                System.out.print(rs.getString("NAME") + "\t\t");
                System.out.println(rs.getString("PRICE") + "\t\t");
            }
            rs.close();
            //业务做完后，我们就释放   ——连接池中的管道复用机制
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    selectData();
                }
            }).start();
        }
    }

}
