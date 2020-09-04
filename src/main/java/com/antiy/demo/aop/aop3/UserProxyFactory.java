package com.antiy.demo.aop.aop3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class UserProxyFactory {


    /**
     *  维护一个目标对象
     */
    private Object target;

    public UserProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        return  Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("开始事务");

                Object returnValue = method.invoke(target, args);

                System.out.println("提交事务");
                return null;
            }
        });
    }
}
