package com.antiy.demo.service.serviceimpl;

import com.antiy.demo.other.MyException;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @Author ygh
 * @Description
 * @Date 2019/11/5
 */
public class KafkaServiceImpl {
    public static void main(String[] args) throws MyException {
        KafkaServiceImpl kafkaService = new KafkaServiceImpl();
        String []test = {"testa","testb"};
        kafkaService.testSimpleProducer(test);
    }

    private void testSimpleProducer(String [] topicName) throws MyException {
        if (topicName.length==0){
            System.out.println("topic");
            throw new MyException("topic不能为空");
        }
        String topic = topicName[0];
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.171.129:9092");
        properties.put("acks","all");
        //If the request fails, the producer can automatically retry,重试次数
        properties.put("retries", 0);

        //Specify buffer size in config 缓存区大小
        properties.put("batch.size", 16384);

        //Reduce the no of requests less than 0   
        properties.put("linger.ms", 1);

        //The buffer.memory controls the total amount of memory available to the producer for buffering.   
        properties.put("buffer.memory", 33554432);

        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer
                <String, String>(properties);

        for(int i = 0; i < 10; i++){
            producer.send(new ProducerRecord(topic,
                    Integer.toString(i),Integer.toString(i)));
        }
        System.out.println("Message sent successfully");
                producer.close();
    }
    private void callback(){}

}
