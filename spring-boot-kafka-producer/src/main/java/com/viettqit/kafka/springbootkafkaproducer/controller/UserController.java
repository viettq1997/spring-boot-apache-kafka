package com.viettqit.kafka.springbootkafkaproducer.controller;

import com.viettqit.kafka.springbootkafkaproducer.model.User;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
@AllArgsConstructor
public class UserController {

    KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC1 = "Kafka_viettq";
    private static final String TOPIC2 = "viettq_kafka";

    KafkaTemplate<String, String> kafkaTemplateString;
    @GetMapping("publish/{message}")
    public String post(@PathVariable("message") final String message) {

        kafkaTemplateString.send(TOPIC1, message);

        return "Published successfully";
    }

    @GetMapping("publish/object/{name}")
    public String postJson(@PathVariable("name") final String name) {

        kafkaTemplate.send(TOPIC2, new User(name, "IT", 12000L));

        return "Published successfully";
    }
}
