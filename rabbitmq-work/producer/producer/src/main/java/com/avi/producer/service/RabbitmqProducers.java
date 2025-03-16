package com.avi.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitmqProducers {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void helloRabbit(String message){
        rabbitTemplate.convertAndSend("rabbitMq_queue","Hello" + message);
    }
}
