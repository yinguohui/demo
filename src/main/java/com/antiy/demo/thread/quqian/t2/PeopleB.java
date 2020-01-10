package com.antiy.demo.thread.quqian.t2;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public class PeopleB extends Thread {
    private Bank bank;

    public PeopleB(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        //用户只从ATM取
        while (Bank.money > 0) {
            bank.ATM(1);
        }
    }
}
