package com.antiy.demo.aop.aop5;

import org.springframework.stereotype.Component;

/**
 * @Author ygh
 * @Description
 * @Date 2020/9/4
 */

@Component()
public class ServiceHandle {
    public void handle(){
        System.out.println("处理业务员");
    }
}
