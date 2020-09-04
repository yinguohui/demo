package com.antiy.demo.aop.aop2;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class UserT2 implements User {
    @Override
    public void save() {
        System.out.println("类型2保存数据");
        System.out.println("保存掐他");
    }
}
