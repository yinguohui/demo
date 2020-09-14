package com.antiy.demo.thread.example.saipao.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public class Test {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Tortoise tortoise = new Tortoise();
        Option option = new Option(tortoise);
        rabbit.calltoback = option;
        Option option1 = new Option(rabbit);
        tortoise.calltoback = option1;
        rabbit.start();
        tortoise.start();
    }
}
