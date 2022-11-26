package com.base.dockerfiledemo.mq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

public class Customer {
    public static void main(String[] args) throws MQClientException {
        // Initialize Consumer and set Consumer Goup Name
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("dlqGroup");

        // Set the address of NameServer
        consumer.setNamesrvAddr("192.168.3.61:9876");
        // Subscribe One or more of topics，and specify the tag filtering conditions, here specify * means receive all tag messages
        consumer.subscribe("TopicTest", "*");
        // Register a callback interface to handle messages received from the Broker
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                // Return to the message consumption status, ConsumeConcurrentlyStatus.CONSUME_SUCCESS for successful consumption
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        // Start Consumer
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}
