package com.antiy.demo.lingkou.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/1
 */
public class MiYao {

    /**
     * 功能描述 :
     * 密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
     * <p>
     * 一、密码长度:
     * <p>
     * 5 分: 小于等于4 个字符
     * <p>
     * 10 分: 5 到7 字符
     * <p>
     * 25 分: 大于等于8 个字符
     * <p>
     * 二、字母:
     * <p>
     * 0 分: 没有字母
     * <p>
     * 10 分: 全都是小（大）写字母
     * <p>
     * 20 分: 大小写混合字母
     * <p>
     * 三、数字:
     * <p>
     * 0 分: 没有数字
     * <p>
     * 10 分: 1 个数字
     * <p>
     * 20 分: 大于1 个数字
     * <p>
     * 四、符号:
     * <p>
     * 0 分: 没有符号
     * <p>
     * 10 分: 1 个符号
     * <p>
     * 25 分: 大于1 个符号
     * <p>
     * 五、奖励:
     * <p>
     * 2 分: 字母和数字
     * <p>
     * 3 分: 字母、数字和符号
     * <p>
     * 5 分: 大小写字母、数字和符号
     * <p>
     * 最后的评分标准:
     * <p>
     * >= 90: 非常安全
     * <p>
     * >= 80: 安全（Secure）
     * <p>
     * >= 70: 非常强
     * <p>
     * >= 60: 强（Strong）
     * <p>
     * >= 50: 一般（Average）
     * <p>
     * >= 25: 弱（Weak）
     * <p>
     * >= 0:  非常弱
     * <p>
     * <p>
     * 对应输出为：
     * <p>
     * VERY_SECURE
     * <p>
     * SECURE,
     * <p>
     * VERY_STRONG,
     * <p>
     * STRONG,
     * <p>
     * AVERAGE,
     * <p>
     * WEAK,
     * <p>
     * VERY_WEAK,
     * <p>
     * <p>
     * 请根据输入的密码字符串，进行安全评定。
     * <p>
     * 注：
     * <p>
     * 字母：a-z, A-Z
     * <p>
     * 数字：-9
     * <p>
     * 符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
     * <p>
     * !"#$%&'()*+,-./     (ASCII码：x21~0x2F)
     * <p>
     * :;<=>?@             (ASCII<=><=><=><=><=>码：x3A~0x40)
     * <p>
     * [\]^_`              (ASCII码：x5B~0x60)
     * <p>
     * {|}~                (ASCII码：x7B~0x7E)
     *
     * @author ygh
     * @date 14:27
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String a = scanner.nextLine();
            judge(a);
        }
    }

    public static void judge(String a) {
        int sum = 0;
        if (a.length() <= 4) {
            sum = sum + 5;
        } else if (a.length() < 8 && a.length() > 4) {
            sum = sum + 10;
        } else if (a.length() >= 8) {
            sum = sum + 25;
        }
        int x = 0;
        int y = 0;
        int z = 0;
        int k = 0;
        for (int i = 0; i < a.length(); i++) {
            if ('0' <= a.charAt(i) && '9' >= a.charAt(i)) {
                x++;
            } else if ('a' <= a.charAt(i) && 'z' >= a.charAt(i)) {
                y++;
            } else if ('A' <= a.charAt(i) && 'Z' >= a.charAt(i)) {
                z++;
            } else {
                k++;
            }
        }
        if (x == 1) {
            sum = sum + 10;
        }
        if (x > 1) {
            sum = sum + 20;
        }
        if ((y > 0 && z == 0) || (z > 0 && y == 0)) {
            sum = sum + 10;
        }
        if (y > 0 && z > 0) {
            sum = sum + 20;
        }
        if (k == 1) {
            sum = sum + 10;
        }
        if (k > 1) {
            sum = sum + 25;
        }
        if (x + y + z == a.length() && x > 0 && (y > 0 || z > 0)) {
            sum = sum + 2;
        }
        if (x > 0 && ((y > 0 && z == 0) || (z > 0 && y == 0)) && z > 0) {
            sum = sum + 3;
        }
        if (x > 0 && y > 0 && z > 0 && k > 0) {
            sum = sum + 5;
        }
        System.out.println(x + " " + y + " " + z + " " + k);
        System.out.println(sum);
        if (sum >= 90) {
            System.out.println("VERY_SECURE");
        } else if (sum >= 80) {
            System.out.println("SECURE");
        } else if (sum >= 70) {
            System.out.println("VERY_STRONG");
        } else if (sum >= 60) {
            System.out.println("STRONG");
        } else if (sum >= 50) {
            System.out.println("AVERAGE");
        }else if (sum >= 25) {
            System.out.println("WEAK");
        }else if (sum >= 0) {
            System.out.println("VERY_WEAK");
        }
    }
}
