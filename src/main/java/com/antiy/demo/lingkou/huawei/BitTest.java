package com.antiy.demo.lingkou.huawei;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/1
 */
public class BitTest {

    /**
     * 功能描述 : 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1
     * @author ygh
     * @date 17:11
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Integer a = scanner.nextInt();
            String re =Integer.toBinaryString(a);
            System.out.println(re);
            String[] temp = re.split("0");
            int sum = 0;
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].length()>sum){
                    sum = temp[i].length();
                }
            }
            System.out.println(sum);
        }
    }
}
