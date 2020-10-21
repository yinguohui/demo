package com.antiy.demo.string;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/19
 */
public class SwitchTest {
    public static void main(String[] args) {
        String test = "123";
        switch (test) {
            case "123":
                System.out.println("正确");
                break;
            case "":
                System.out.println("错误");
                break;
        }
    }
}
