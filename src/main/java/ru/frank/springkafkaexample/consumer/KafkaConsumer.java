package ru.frank.springkafkaexample.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
    private String event;

    @KafkaListener(topics = "${kafka.topicName}")
    public void receive(String message) {
        System.out.println("Received message: " + message);
        event = message;
    }

    public String getEvent() {
        return event;
    }
}
