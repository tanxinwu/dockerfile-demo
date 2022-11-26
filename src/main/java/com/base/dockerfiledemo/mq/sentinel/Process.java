package com.base.dockerfiledemo.mq.sentinel;


import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.UnsupportedEncodingException;

public class Process {

    public static void main(String[] args) throws MQClientException, MQBrokerException, RemotingException, InterruptedException, UnsupportedEncodingException {
        // Initialize a producer and set the Producer group name
        DefaultMQProducer producer = new DefaultMQProducer("testGroup"); //（1）
        // Set the address of NameServer
        producer.setNamesrvAddr("192.168.3.61:9876");  //（2）
        // Start Producer
        producer.start();
        for (int i = 10000; i < 10100; i++) {
            // Create a message and set the topic, tag, body and so on. The tag can be understood as a label to categorize the message, and RocketMQ can filter the tag on the consumer side.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Test Flow " + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );   //（3）
            // Use the producer to send and wait for the result of sending synchronously
            SendResult sendResult = producer.send(msg);   //（4）
            System.out.printf("%s%n", sendResult);
        }
        // Close the producer once it is no longer in use
        producer.shutdown();
    }
}
