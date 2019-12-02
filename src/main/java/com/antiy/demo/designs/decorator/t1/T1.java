package com.antiy.demo.designs.decorator.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/29
 */
public class T1 {
    public static void main(String[] args) {
        //使用装饰器
        Component component = new ConcreteDecorator(new ConcretComponent());
        component.biu();
    }
}
