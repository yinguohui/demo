package com.antiy.demo.string;

/**
 * @Author ygh
 * @Description
 * 两个对象hashcode相等，那么equals也一定相等吗？
 * @Date 2020/10/21
 */
public class StringHashCode {
    public static void main(String[] args) {
        test1();
    }
    private static void test1(){
        String a = new String("通话");
        String b= new String("重地");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
