package com.antiy.demo.java8.fanxing;

/**
 * @Author ygh
 * @Description 泛型实现1
 *
 * 1,适用于多种数据类型执行相同的代码（代码复用）
 * 2, 泛型中的类型在使用时指定，不需要强制类型转换（类型安全，编译器会检查类型）
 * @Date 2020/11/23
 */
public class GenericTestImpl1<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        GenericTestImpl1<String> testImpl1 = new GenericTestImpl1<>();
        testImpl1.setData("测试");
        System.out.println(testImpl1.getData());
    }
}
