package com.antiy.demo.java8.fanxing;

/**
 * @Author ygh
 * @Description 泛型测试 --- >为撒需要泛型
 * @Date 2020/11/23
 */
public class GenericTest {
    private static int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static float add(float a, float b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static double add(double a, double b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    private static <T extends Number> double add(T a, T b) {
        System.out.println(a + "+" + b + "=" + (a.doubleValue() + b.doubleValue()));
        return a.doubleValue() + b.doubleValue();
    }

    public static void main(String[] args) {
        GenericTest.add(1, 2);
        GenericTest.add(1f, 2f);
        GenericTest.add(1d, 2d);
        GenericTest.add(Integer.valueOf(1), Integer.valueOf(2));
        GenericTest.add(Float.valueOf(1), Float.valueOf(2));
        GenericTest.add(Double.valueOf(1), Double.valueOf(2));
    }
}
