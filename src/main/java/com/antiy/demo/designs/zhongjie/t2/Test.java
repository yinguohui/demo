package com.antiy.demo.designs.zhongjie.t2;

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
        D d = new D(a, b, c);
        d.print(a)
        ;
    }
}
