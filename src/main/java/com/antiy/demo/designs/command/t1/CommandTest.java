package com.antiy.demo.designs.command.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/12
 */
public class CommandTest {
    public static void main(String[] args) {
        Light light = new Light();
        LightOnCommand command = new LightOnCommand(light);
        SimpleRemoteControl control = new SimpleRemoteControl();
        control.setCommand(command);
        control.buttonWasPressed();
    }
}
