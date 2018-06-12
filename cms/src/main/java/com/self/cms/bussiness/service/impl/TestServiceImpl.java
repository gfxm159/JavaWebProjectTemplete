package com.self.cms.bussiness.service.impl;

import com.self.cms.bussiness.service.ITestService;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
@Service
public class TestServiceImpl implements ITestService {

    Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);
    @Autowired
    private JmsMessagingTemplate jmsTemplate;

    /**
     * 使用ActiveMQ发送一条消息
     * @param message
     */
    @Override
    public void sendMessage(String message) {
        Destination destination = new ActiveMQQueue("test.queue");
        jmsTemplate.convertAndSend(destination, message);
        logger.info("==================================>>>>>>>>>"+message);
    }
}
