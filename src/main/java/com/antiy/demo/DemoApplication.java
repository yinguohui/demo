package com.antiy.demo;

import com.antiy.demo.aop.aop5.ServiceHandle;
import com.antiy.demo.utils.SpringContextUtil;
import com.battcn.swagger.annotation.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@EnableSwagger2Doc
@MapperScan(basePackages = {"com.antiy.demo.dao"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
