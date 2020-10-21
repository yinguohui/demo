package com.antiy.demo.designs.decorator.t1;


/**
 * 功能描述 :装饰类
 *
 * @author ygh
 * @date 9:56
 */
public class Decorator implements Component {

    public Component component;

    public Decorator(Component component) {

        this.component = component;
    }

    public void biu() {

        this.component.biu();
    }
}