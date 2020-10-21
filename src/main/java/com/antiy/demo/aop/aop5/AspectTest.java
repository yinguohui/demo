package com.antiy.demo.aop.aop5;

import com.antiy.demo.DemoApplication;
import com.antiy.demo.utils.SpringContextUtil;
import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */

@SpringBootApplication
public class AspectTest {
    public static void main(String[] args) {
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");
//        ServiceHandle landlord =  context.getBean("serviceHandle", ServiceHandle.class);
        SpringApplication.run(DemoApplication.class, args);
        ApplicationContext context = SpringContextUtil.getApplicationContext();
        ServiceHandle landlord = context.getBean("serviceHandle", ServiceHandle.class);
        landlord.handle();
    }
}
