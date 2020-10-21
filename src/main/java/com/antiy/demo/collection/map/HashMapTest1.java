package com.antiy.demo.collection.map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author ygh
 * @Description hashMap
 * @Date 2020/9/17
 */
@SpringBootApplication
public class HashMapTest1 {
    public static void main(String[] args) {
        System.out.println(a());
//        Map map = new HashMap(10);
//        map.toString();
//        ConcurrentHashMap map1 = new ConcurrentHashMap<>();
//        int i = 16;
//        System.out.println( i <<= 2);
//        String a;
//        StringBuilder b;
//        StringBuffer c;
//        ApplicationContext context = new ClassPathXmlApplicationContext(args);
//        context.getBean("");
    }

    public static int a(){
        int a= 0;
        try {
            return a;
        }catch (Exception e){
            return a;
        }finally {
            System.out.println(11+a);
            a = a+3;
        }
    }
}
