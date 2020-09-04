package com.antiy.demo.aop.aop2;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class UserT1 implements User{
    @Override
    public void save() {
        System.out.println("保存用户数据");
    }
}
