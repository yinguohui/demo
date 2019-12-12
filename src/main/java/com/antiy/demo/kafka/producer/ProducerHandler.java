package com.antiy.demo.kafka.producer;

import com.antiy.demo.kafka.config.KafkaOperationTask;
import com.antiy.demo.kafka.dto.ProducerMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * @ClassName: ProducerHandler
 * @Auther: chenguoming
 * @Date: 2019/5/8 13:18
 * @Description: kafka 生产者处理类
 */
@Component
public class ProducerHandler {

    private static Logger log = LoggerFactory.getLogger(ProducerHandler.class);

    @Resource
    private KafkaTemplate kafkaTemplate;

    /**
     * @param
     * @return void
     * @Description 创建topic，发送至kafka中心
     * @Date 11:32 2019/5/7
     */
    public void sendMsg(ProducerMessageDto message) {
        try {
            String jsonMsg = message.getMsg();
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(message.getType(), jsonMsg);
            future.addCallback(
                    new ListenableFutureCallback<SendResult<String, String>>() {
                        @Override
                        public void onFailure(Throwable throwable) {
                            log.info("send msg to kafka failed");
                            KafkaOperationTask.localQueenAdd(message);
                        }

                        @Override
                        public void onSuccess(SendResult<String, String> OperLogSendResult) {
                            log.info("send msg to kafka success");
                        }
                    });
        } catch (NullPointerException e) {
            // 日志记录kafka未开启
            log.error("Logging to kafka switch is not turned on");
        } catch (Exception e) {
            // 发送消息失败，缓存消息至本地
            KafkaOperationTask.localQueenAdd(message);
            log.error( "The cache operation log was successful");
        }
    }
}
