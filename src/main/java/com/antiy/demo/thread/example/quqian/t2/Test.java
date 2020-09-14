package com.antiy.demo.thread.example.quqian.t2;

/**
 * @Author ygh
 * @Description 银行取钱
 * @Date 2020/1/9
 */
public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();
        People a = new People(bank);
        PeopleB b = new PeopleB(bank);
        a.start();
        b.start();
    }
}
