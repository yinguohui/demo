package com.antiy.demo.designs.zhongjie.t2;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/13
 */
public class D {
    private A a;
    private B b;
    private C c;

    public D(A a, B b, C c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void print(Object o) {
        if (o instanceof A) {
            System.out.println("这是" + a.getName());
            System.out.println("打印" + b.getName() + c.getName());
        } else if (o instanceof B) {
            System.out.println("这是" + b.getName());
            System.out.println("打印" + a.getName() + c.getName());
        } else if (o instanceof C) {
            System.out.println("这是" + c.getName());
            System.out.println("打印" + a.getName() + b.getName());
        } else {
            System.out.println("啥也不是");
        }
    }
}
