package com.antiy.demo.exception;


import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/20
 */
public class Test1 {
    public static void main(String[] args) {
        String file = "C:\\Users\\yinguohui\\Desktop\\192.168.1.66downLog\\2019-10-22\\watchdog-manager.log";
        FileReader reader;
        try {
            reader = new FileReader(file);
            Scanner scanner = new Scanner(reader);
            String text = scanner.nextLine();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("执行finally");
        }
    }
}
