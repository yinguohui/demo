package com.antiy.demo.thread.example.quqian.t2;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public class Bank {
    static int money = 1000;

    // 柜台取钱
    public synchronized void Counter(int money) {
        Bank.money -= money;
        System.out.println("柜台取走了" + money + "还剩下" + Bank.money);
    }

    public synchronized void ATM(int money) {
        Bank.money -= money;
        System.out.println("ATM取走了" + money + "还剩下" + Bank.money);
    }
}
