package com.avi.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PriceRateProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PriceRateProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    int count = 0;

    @Scheduled(fixedRate = 500)
    public void priceRate(){
        count++;
        LOGGER.info("count is: {}", count);
        rabbitTemplate.convertAndSend("course.priceRate" ,"Price rate: "+ count);
    }
}
