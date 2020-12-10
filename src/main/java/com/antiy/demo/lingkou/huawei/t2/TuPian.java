package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class TuPian {

    /**
     * 功能描述 :
     * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024
     * Lily的所有图片按照从小到大的顺序输出
     * Ihave1nose2hands10fingers
     * 0112Iaadeeefghhinnnorsssv
     * @author ygh
     * @date 14:22
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine();
            char[] re = a.toCharArray();
            for (int i = 0; i < re.length-1; i++) {
                for (int j = i+1; j < re.length; j++) {
                    if (re[i]>re[j]){
                        char temp = re[j];
                        re[j] = re[i];
                        re[i] = temp;
                    }
                }
            }
            StringBuilder result = new StringBuilder();
            result.append(re);
            System.out.println(result);
        }
    }
}
