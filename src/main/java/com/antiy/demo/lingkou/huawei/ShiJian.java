package com.antiy.demo.lingkou.huawei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/2
 */
public class ShiJian {

    /**
     * 功能描述 :根据输入的日期，计算是这一年的第几天。。
     * <p>
     * 测试用例有多组，注意循环输入
     *
     * @author ygh
     * @date 14:49
     */
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            Integer y = Integer.valueOf(a.split(" ")[0]);
            a = a.replaceAll(" ","-");
            try {
                Date date =simpleDateFormat.parse("2011-12-31");
                System.out.println(date.toString());
                long s = simpleDateFormat.parse("2011-12-31").getTime();
                long time = simpleDateFormat.parse(a).getTime();
                System.out.println(s);
                System.out.println(time);
                System.out.println((time-s)/1000/60/60/24);
            } catch (ParseException e) {
                System.out.println(-1);
            }
        }
    }
}
