package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class ChongFuShu {


    /**
     * 功能描述 :
     * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
     * 保证输入的整数最后一位不是0
     * 9876673
     * 输出
     * 37689
     *
     * @author ygh
     * @date 10:59
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String re = scanner.nextLine();
            StringBuilder s = new StringBuilder();
            s.append(re.charAt(re.length() - 1));
            for (int i = re.length() - 1; i >= 0; i--) {
                if (s.indexOf(String.valueOf(re.charAt(i)))<0){
                    s.append(re.charAt(i));
                }
            }
            System.out.println(s.toString());
        }
    }

}
