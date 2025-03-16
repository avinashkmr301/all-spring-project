package com.avi.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitConsumer {

    @RabbitListener(queues = "rabbitMq_queue")
    public void consumeMessage(String message){
        System.out.println("Consume messages from queue: " + message);
    }
}
