package com.antiy.demo.ioc.ioc2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/8
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        User user = (User) context.getBean("user");

        System.out.println(user.getUserName() + "----" + user.getEmail());
    }
}
