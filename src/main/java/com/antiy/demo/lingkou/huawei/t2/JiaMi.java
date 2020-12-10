package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/10
 */
public class JiaMi {


    /**
     * 功能描述 :
     * <p>
     * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
     * 如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
     * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
     * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
     * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的
     * 字母(字母字符的大小写状态应该保留)。因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
     * 请实现下述接口，通过指定的密匙和明文得到密文。
     *
     * @author ygh
     * @date 16:50
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ss = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        while (scanner.hasNext()) {
            String mi = scanner.nextLine();
            String in = scanner.nextLine();
            String inr = in.toUpperCase();
            mi = mi.toUpperCase();
            for (int i = 0; i < mi.length(); i++) {
                s = s.replace(mi.charAt(i)+"", "");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(mi);
            stringBuilder.append(s);
            String re= stringBuilder.toString();
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < in.length(); i++) {
                int a =ss.indexOf(inr.charAt(i));
                string.append(re.charAt(a));
            }
            char[] ji = string.toString().toCharArray();
            for (int i = 0; i < in.length(); i++) {
                if (in.charAt(i)>='a'&&in.charAt(i)<='z'){
                    ji[i] = (char) (ji[i]+32);
                }
            }

            for (int i = 0; i < ji.length; i++) {
                System.out.print(ji[i]);
            }
        }
    }
}
