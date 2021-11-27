package com.viettqit.kafkaconsumer.springbootkafkaconsumer.listener;

import com.viettqit.kafkaconsumer.springbootkafkaconsumer.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(ConsumerListener.class);

    @KafkaListener(topics = "Kafka_viettq", groupId = "${kafka-consumer-group-id-string}")
    public void consumer(String message) {
        LOGGER.info("Consumer message: " + message);
    }

    @KafkaListener(topics = "viettq_kafka", groupId = "${kafka-consumer-group-id-user}",
            containerFactory = "kafkaListenerContainerObjectFactory")
    public void comsumerJson(User user) {
        LOGGER.info("Consumer Json: " + user);
    }
}
