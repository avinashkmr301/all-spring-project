package com.avi.producer;

import com.avi.producer.service.RabbitmqProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ThreadLocalRandom;

@EnableScheduling
@SpringBootApplication
public class ProducerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private RabbitmqProducers rabbitmqProducers;

	@Override
	public void run(String... args) throws Exception {
		rabbitmqProducers.helloRabbit("Chat-gpt " + ThreadLocalRandom.current().nextInt());
	}
}
