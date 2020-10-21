package com.antiy.demo.designs.zhongjie.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/13
 */
public class B {
    private String name;

    public B(String name) {
        this.name = name;
    }

    public void print(A a, C c) {
        System.out.println("这是" + this.name);
        System.out.println("打印" + a.getName() + c.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
