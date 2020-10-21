package com.antiy.demo.designs.zhongjie.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/13
 */
public class Test {
    public static void main(String[] args) {
        A a = new A("A");
        B b = new B("B");
        C c = new C("C");
        a.print(b, c);
        b.print(a, c);
        c.print(a, b);
    }
}
