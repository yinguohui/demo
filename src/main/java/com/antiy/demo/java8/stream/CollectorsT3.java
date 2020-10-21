package com.antiy.demo.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/25
 */
public class CollectorsT3 {

    /**
     * 功能描述 : Collectors.counting() 用于统计流中元素的个数。
     *
     * @author ygh
     * @date 13:53
     */
    private static void count() {
        List list = Arrays.asList(1, 2, 3);
        long count = (long) list.stream().collect(Collectors.counting());
        System.out.println(count);
    }


    /**
     * 功能描述 :Collectors.joining() 方法用某个指定的拼接字符串把所有元素拼接成一个字符串，并添加可选的前缀和后缀
     *
     * @author ygh
     * @date 15:06
     */
    private static void join() {
        List list = Arrays.asList("a", "b", "c");
        String re = (String) list.stream().collect(Collectors.joining(",", "(", ")"));
        System.out.println(re);
    }


    /**
     * 功能描述 : Collectors.maxBy() 和 Collectors.minBy() 两个方法分别用于计算流中所有元素的最大值和最小值。
     *
     * @author ygh
     * @date 15:09
     */
    private static void maxBy() {
        List list = Arrays.asList(1, 99, 12, 33, 55);
        int re = (int) list.stream().collect(Collectors.maxBy(new CollectorsT3().new IntegerComp()));
        System.out.println(re);
    }


    /**
     * 功能描述 : Collectors.summingInt() 方法将流中的所有元素视为 int 类型，并计算所有元素的总和 ( sum )
     *
     * @author ygh
     * @date 15:39
     */

    private static void sum() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        int a = list.stream().collect(Collectors.summingInt(i -> i));
        System.out.println(a);
    }


    /**
     * 功能描述 :Collectors.toList() 将流中的所有元素导出到一个列表 ( List ) 中
     *
     * @author ygh
     * @date 15:42
     */
    private static void toList() {
        List list = Stream.of("aa", "bb", "cc").collect(Collectors.toList());
        list.forEach(i -> System.out.println(i));
    }

    /**
     * 功能描述 : Collectors.toMap() 将流中的所有元素导出到一个哈希表 ( Map ) 中。该方法接受两个参数，第一个参数用于生成键 ( key ) ，
     * 第二个参数用于生成值 ( value )。两个参数都是 Lambda 表达式。
     *
     * @author ygh
     * @date 15:45
     */
    private static void toMap() {
        Map<String, String> map = Stream.of("AA", "BB", "CC").collect(Collectors.toMap(k -> k, v -> v));
        map.forEach((k, v) -> System.out.println("key:" + k + "Value:" + v));
    }


    /**
     * 功能描述 : Collectors.mapping() 一般用于多重 map and reduce 中。 Java 文档中描述的原型如下
     *
     * @author ygh
     * @date 15:49
     */

    private static void mapping() {
        List<Person> list = Person.getList();
        Map<Integer, String> nameByAge
                = list.stream().collect(Collectors.groupingBy(Person::getAge,
                Collectors.mapping(Person::getName, Collectors.joining(","))));
        nameByAge.forEach((k, v) -> System.out.println("Age:" + k + "  Persons: " + v));
    }

    public static void main(String[] args) {
        count();
        join();
        //maxBy();
        sum();
        toList();
        toMap();
        mapping();
    }

    class IntegerComp implements Comparator<Integer> {
        @Override
        public int compare(Integer i1, Integer i2) {
            if (i1 >= i2) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public static List<Person> getList() {
            List<Person> list = new ArrayList<>();
            list.add(new Person("Ram", 30));
            list.add(new Person("Shyam", 20));
            list.add(new Person("Shiv", 20));
            list.add(new Person("Mahesh", 30));
            return list;
        }
    }
}
