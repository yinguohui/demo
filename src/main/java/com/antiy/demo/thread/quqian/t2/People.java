package com.antiy.demo.thread.quqian.t2;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public class People extends Thread {
    private Bank bank;

    public People(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        //这个用户只在柜台取钱
        while (Bank.money > 0) {
            bank.Counter(1);
        }
    }
}
