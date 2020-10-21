package com.antiy.demo.ioc.load;

import com.antiy.demo.ioc.bean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new
                ClassPathXmlApplicationContext("beans-factoryBean.xml");
        Car car = (Car) ctx.getBean("car");
        System.out.println(car);
        HashMap hashMap = new HashMap();
        hashMap.put("a","1");
        LinkedHashMap linkedHashMap = new LinkedHashMap<>(10,0.75f,false);
    }
}