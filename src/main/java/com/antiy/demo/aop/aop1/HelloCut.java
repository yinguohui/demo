package com.antiy.demo.aop.aop1;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class HelloCut implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("这是代理前的事情");
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("这是代理后的事情");
    }
}
