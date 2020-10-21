package com.antiy.demo.string;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */

/**
 * 字符串池。每当我们创建一个字符串对象时，首先就会检查字符串池中是否存在面值相等的字符串，如果有，则不再创建，直接放回字符串池中对该对象的引用，
 * 若没有则创建然后放入到字符串池中并且返回新建对象的引用。这个机制是非常有用的，因为可以提高效率，减少了内存空间的占用
 */
public class StringNullAndNew {
    public static void main(String[] args) {
        String a = "";
        String b = new String();
        String c = new String();
        String d = "";
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(b == c);
        System.out.println(a == d);
    }
}
