package com.antiy.demo.aop.aop3;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class ProxyTest {
    public static void main(String[] args) {
        User1 user1 = new User1T1();
        User1 user1T1 = (User1) new UserProxyFactory(user1).getProxyInstance();
        //执行代理方法
        user1T1.save();
    }
}
