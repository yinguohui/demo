package com.antiy.demo.kafka.dto;

import java.io.Serializable;

/**
 * @ClassName: messageDto
 * @Auther: chenguoming
 * @Date: 2019/5/7 13:19
 * @Description: 消息dto
 */
public class ProducerMessageDto implements Serializable {

    /**
     * 消息topic类型  这里要和KafkaProducerEnum类里的枚举对应起来
     */
    private String type;

    /**
     * 消息内容  json字符串数据
     */
    private String msg;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
