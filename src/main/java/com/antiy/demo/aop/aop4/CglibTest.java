package com.antiy.demo.aop.aop4;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class CglibTest {

    public static void main(String[] args) {

        //目标对象
        User2T1 target = new User2T1();
        System.out.println(target.getClass());
        //代理对象
        User2T1 proxy = (User2T1) new UserProxy(target).getProxyInstance();
        System.out.println(proxy.getClass());
        //执行代理对象方法
        proxy.save();
    }
}
