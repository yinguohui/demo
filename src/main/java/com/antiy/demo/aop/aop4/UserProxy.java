package com.antiy.demo.aop.aop4;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class UserProxy implements MethodInterceptor {

    private Object target;
    public UserProxy(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        //工具类
        Enhancer en = new Enhancer();
        //设置父类
        en.setSuperclass(target.getClass());
        //设置回调函数
        en.setCallback(this);
        //创建子类对象代理
        return en.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("开启事务");
        // 执行目标对象的方法
        Object returnValue = method.invoke(target, objects);
        System.out.println("关闭事务");
        return null;
    }
}
