package com.antiy.demo.designs.decorator.t1;


/**
 * 功能描述 : 具体装饰类
 * @author ygh
 * @date 9:56
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component component) {

        super(component);
    }

    @Override
    public void biu() {
        
        System.out.println("ready?go!");
        this.component.biu();
    }
}