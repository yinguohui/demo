package com.antiy.demo.thread.example.saipao.t1;

/**
 * @Author ygh
 * @Description 兔子每秒0.5米的速度，每跑2米休息10秒，
 * @Date 2020/1/9
 */
public class Rabbit extends Animal{
    @Override
    public void running() {
        length -= 0.5;
        //跑完了
        if (length <= 0) {
            length = 0;
            System.out.println("兔子跑完了，取得胜利");
            //通知乌龟不跑了
            if (calltoback != null) {
                calltoback.win();
            }
        }
        //未跑完
        if (length % 2 == 0) {
            //没跑2米休息10秒
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("兔子跑了" + 0.5 + "米，还剩" + length + "米");
    }
}
