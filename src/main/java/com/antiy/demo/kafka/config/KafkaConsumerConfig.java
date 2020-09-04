package com.antiy.demo.kafka.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ygh
 * @Description
 * @Date 2019/12/9
 */
//@Configuration
//@EnableKafka
public class KafkaConsumerConfig {

    /**
     * kafka服务器地址
     */
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    private int requestTimeoutMS = 300000;

    private int maxPollRecords = 1000;

    private int maxPollIntervalMS = 120000;

    private int sessionTimeoutMS = 60000;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String,String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        // 加入配置
        factory.setConsumerFactory(sampleConsumerFactory());
        factory.setConcurrency(5);
        factory.getContainerProperties().setPollTimeout(3000);
        //开启手动ACK.
        //factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    private ConsumerFactory<String, String> sampleConsumerFactory() {
        //key.serializer和value.serializer示例：将用户提供的key和value对象ProducerRecord转换成字节，你可以使用附带的ByteArraySerizlizaer
        // 或StringSerializer处理简单的byte和String类型
        return new DefaultKafkaConsumerFactory(sampleConsumerConfiguration(), new StringDeserializer(), new StringDeserializer());
    }


    /**
     * 功能描述 : 加载配置
     * @author ygh
     * @date 10:26
     */
    private Map<String, Object> sampleConsumerConfiguration() {
        Map<String, Object> props = new HashMap<>(7);
        // 服务器地址
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
        //强烈建议关闭自动确认,我们使用手动ACK模式,Spring Kafka基于JMS语义为我们设计好了兼容实现.
        //true，消费者的偏移量将在后台定期提交；false关闭自动提交位移，在消息被完整处理之后再手动提交位移
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        //如何设置为自动提交（enable.auto.commit=true）,这里设置自动提交周期
        props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, this.maxPollIntervalMS);
        //单次poll允许获取的最多条数.
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, this.maxPollRecords);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, this.sessionTimeoutMS);
        // 请求超时时间
        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, this.requestTimeoutMS);
        // 组id
        props.put(ConsumerConfig.GROUP_ID_CONFIG, this.groupId);
        // 字符串配置
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return props;
    }

}
