package com.antiy.demo.aop.aop5;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author ygh
 * execution 匹配式
 * 匹配所有类public方法  execution(public * *(..))
 * 匹配指定包下所有类方法 execution(* com.baidu.dao.*(..)) 不包含子包
 * execution(* com.baidu.dao..*(..))  ..*表示包、子孙包下所有类
 * 匹配指定类所有方法 execution(* com.baidu.service.UserService.*(..))
 * 匹配实现特定接口所有类方法
 *     execution(* com.baidu.dao.GenericDAO+.*(..))
 * 匹配所有save开头的方法 execution(* save*(..))
 * @Description
 * @Date 2020/9/4
 */
@Component
@Aspect
public class AspectT {

    @Before("execution(* com.antiy.demo.aop.aop5..*(..))")
    public void before(){
        System.out.println("开始之前");
    }

    @After("execution(* com.antiy.demo.aop.aop5..*(..))")
    public void after(){
        System.out.println("开始之后");
    }
}
