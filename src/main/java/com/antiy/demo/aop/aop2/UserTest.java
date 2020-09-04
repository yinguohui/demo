package com.antiy.demo.aop.aop2;

/**
 * @Author ygh
 * @Description 测试
 * @Date 2020/9/4
 */
public class UserTest {
    public static void main(String[] args) {
        User user = new UserT1();
        User user1 = new UserT2();
        UserT1Proxy proxy = new UserT1Proxy(user);
        UserT1Proxy proxy1 = new UserT1Proxy(user1);
        proxy.save();
        proxy1.save();
    }
}
