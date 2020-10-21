package com.antiy.demo.aop.aop2;

/**
 * @Author ygh
 * @Description 用户代理lei
 * @Date 2020/9/4
 */
public class UserT1Proxy implements User {

    private User target;

    public UserT1Proxy(User target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("开始事务");
        target.save();
        System.out.println("事务结束");
    }
}
