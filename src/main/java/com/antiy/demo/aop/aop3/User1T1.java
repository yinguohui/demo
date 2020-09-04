package com.antiy.demo.aop.aop3;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */
public class User1T1 implements User1 {
    @Override
    public void save() {
        System.out.println("保存数据");
    }
}
