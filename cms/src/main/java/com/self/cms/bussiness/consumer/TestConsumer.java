package com.self.cms.bussiness.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * ActiveMQ消费者
 */
@Component
public class TestConsumer {
    Logger logger = LoggerFactory.getLogger(TestConsumer.class);

    /**
     * 提供一个ActiveMQ消费消息的实例
     * @param text
     */
    @JmsListener(destination = "test.queue")
    public void receiveQueue(String text) {
        logger.info("<<<<<<<<<================================"+text);
    }
}
