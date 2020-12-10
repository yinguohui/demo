package com.antiy.demo.lingkou.huawei;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/1
 */
public class HuiWenTest {


    /**
     * 功能描述 :
     * 给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
     * 所谓回文串，指左右对称的字符串。
     * 所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
     * （注意：记得加上while处理多个测试用例）
     * @author ygh
     * @date 17:21
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String a = scanner.nextLine();
            Map<String, List<Integer>> map = new HashMap();
            for (int i = 0; i < a.length(); i++) {
                if (map.get(a.charAt(i))!=null){
                    map.put(String.valueOf(a.charAt(i)),map.get(a.charAt(i)));
                }

            }
        }
    }
}
