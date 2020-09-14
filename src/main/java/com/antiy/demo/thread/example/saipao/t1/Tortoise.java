package com.antiy.demo.thread.example.saipao.t1;

/**
 * @Author ygh
 * @Description 乌龟每秒跑0.1米，不休息
 * @Date 2020/1/9
 */
public class Tortoise extends Animal {
    @Override
    public void running() {
        length -= 0.1;
        //跑完了
        if (length <= 0) {
            length = 0;
            System.out.println("乌龟跑完了，取得胜利");
            //通知兔子不跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        System.out.println("乌龟跑了" + 0.1 + "米，还剩" + length + "米");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
