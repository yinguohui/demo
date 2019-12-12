package com.antiy.demo.kafka.config;

import com.antiy.demo.kafka.dto.ProducerMessageDto;
import com.antiy.demo.kafka.producer.ProducerHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 描述:
 * 定时任务
 * 当消息发送失败将消息放置在本地缓存中，
 * 在后续的定时任务中触发发送
 *
 * @author Jleeci
 * @create 2019-01-07 14:56
 */
@Component
@ConditionalOnProperty(name = "logging.kafka.enable", havingValue = "true")
@EnableScheduling
public class KafkaOperationTask {

    private static ConcurrentLinkedQueue<ProducerMessageDto> localQueen = new ConcurrentLinkedQueue<>();
    @Resource
    private ProducerHandler handler;

    public static void localQueenAdd(ProducerMessageDto message) {
        if (!localQueen.contains(message)) {
            //todo  后续考虑放入redis缓存
            //todo  kafka重试机制研究
            localQueen.add(message);
        }
    }

    /**
     * 每两小时检测一次是否存在未发送的消息
     */
    @Scheduled(cron = "0 0 0/2 * * ?") //每2小时执行一次
    private void task() {
        sendMessage();
    }

    private void sendMessage() {
        if (localQueen.isEmpty()) {
            return;
        }
        handler.sendMsg(localQueen.poll());
        sendMessage();
    }

}
