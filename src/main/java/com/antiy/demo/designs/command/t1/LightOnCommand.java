package com.antiy.demo.designs.command.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/12
 */
public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light){
        light = this.light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
