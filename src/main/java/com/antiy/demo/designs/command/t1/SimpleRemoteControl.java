package com.antiy.demo.designs.command.t1;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/12
 */
public class SimpleRemoteControl {
    Command command;
    public SimpleRemoteControl(){

    }
    public void setCommand(Command command){
        this.command = command;
    }
    public void buttonWasPressed(){
        command.execute();
    }
}
