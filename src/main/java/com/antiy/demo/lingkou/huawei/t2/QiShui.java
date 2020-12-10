package com.antiy.demo.lingkou.huawei.t2;

import java.util.Scanner;

/**
 * @Author ygh
 * @Description
 * @Date 2020/12/9
 */
public class QiShui {

    /**
     * 功能描述 :
     * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的
     * ，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
     * @author ygh
     * @date 14:41
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Integer s = Integer.parseInt(scanner.nextLine());
            if (s==0){
                break;
            }
            System.out.println(f(s));
        }
    }
    public static int f(int n){
        if (n==2){
            return 1;
        }
        if (n==1||n==0){
            return 0;
        }else {
            return f(n-2)+1;
        }
    }
}
