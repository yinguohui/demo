package com.antiy.demo.thread.example.saipao.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2020/1/9
 */
public class Option implements Animal.Calltoback {
    private Animal animal;

    public Option(Animal animal) {
        this.animal = animal;
    }

    @Override
    public void win() {
        animal.stop();
    }
}
