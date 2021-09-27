package ru.frank.springkafkaexample.service;

import org.springframework.stereotype.Service;
import ru.frank.springkafkaexample.consumer.KafkaConsumer;
import ru.frank.springkafkaexample.producer.KafkaProducer;

import java.util.Collections;
import java.util.List;

@Service
public class EventService {
    private final KafkaProducer producer;
    private final KafkaConsumer consumer;

    public EventService(KafkaProducer producer, KafkaConsumer consumer) {
        this.producer = producer;
        this.consumer = consumer;
    }

    public void addEvent(String message) {
        producer.sendMessage(message);
    }

    public List<String> getEvents() {
        return Collections.singletonList(consumer.getEvent());
    }
}
