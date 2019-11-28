package com.antiy.demo.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/25
 */
public class CollectorsT2 {

    /**
     * 功能描述 : 它可接受两个参数，第一个参数用于 reduce 操作，而第二参数用于 map 操作。
     * 先把 [1,2,3,4] 这个集合传递给 s-> s*2 lambda 表达式，计算得出结果为 [2,4,6,8] ，然后再把 [2,4,6,8]
     * 传递给 v->v*2 表达式，计算得出 [4,6,8,10] ，然后传递给 Collectors.averagingLong() 计算得到结果为 9.0
     * @author ygh
     * @date 13:45
     */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        double re = list.stream().collect(Collectors.collectingAndThen(Collectors.averagingLong(v->v+2),s->s*2));
        System.out.println(re);
    }
}
