package com.antiy.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/25
 */
public class CollectorsT1 {


    /**
     * 功能描述 :
     *  方法将流中的所有元素视为 各种 类型并计算他们的平均值。该方法返回的是同一个 Collectors 实例
     *  Java 所有集合的 stream().collect() 可以接受一个收集器实例作为其参数并返回该收集器的计算结果
     *  averagingInt averagingLong averagingDouble
     * @author ygh
     * @date 13:31
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,4,5);
        double re = list.stream().collect(Collectors.averagingDouble(d->(d*2)));
        System.out.println(re);
    }
}
