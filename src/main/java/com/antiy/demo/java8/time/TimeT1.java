package com.antiy.demo.java8.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/26
 */
public class TimeT1 {
    public static void main(String[] args) {
        //f1();
        //f2();
        //f3();
        //f4();
        f5();
        f6();
        f7();
    }

    private static void f1() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("  " + localDateTime);
    }

    private static void f2() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("  " + localDateTime);
        System.out.println("  " + localDateTime.toLocalDate());
        System.out.println("  " + localDateTime.toLocalTime());
    }

    private static void f3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("  " + localDateTime);
        System.out.println("  " + localDateTime.getMonth());
        System.out.println("  " + localDateTime.getDayOfMonth());
        System.out.println("  " + localDateTime.getDayOfWeek());
        System.out.println("  " + localDateTime.getDayOfYear());
        System.out.println("  " + localDateTime.getSecond());
    }

    private static void f4() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(11).withYear(2018);
        System.out.println(localDateTime1);
        System.out.println(localDateTime);
    }

    private static void f5() {
        LocalDate localDate = LocalDate.of(2018, 1, 22);
        LocalTime localTime = LocalTime.of(22, 44);
        System.out.println(localDate);
        System.out.println(localTime);
    }

    private static void f6() {
        LocalDateTime localDateTime = LocalDateTime.parse("2018-01-11T12:55");
        System.out.println(localDateTime);
    }

    // 时区处理


    // 格式转化

    private static void f7() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd H:m:s");
        String text = localDateTime.format(formatter);
        System.out.println(text);
        LocalDateTime parsed = LocalDateTime.parse(text, formatter);
        System.out.println("解析后:" + parsed);
    }
}
