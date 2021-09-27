package ru.frank.springkafkaexample.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.frank.springkafkaexample.configuration.KafkaProperties;

@Component
public class KafkaProducer {
    private final KafkaProperties properties;
    private final KafkaTemplate<String, String> template;

    public KafkaProducer(KafkaProperties properties, KafkaTemplate<String, String> template) {
        this.properties = properties;
        this.template = template;
    }

    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future =
                template.send(properties.topicName, message);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println(
                        "Sent message: " + message +
                                ", offset:" + result.getRecordMetadata().offset() +
                                ", timestamp: "+ result.getRecordMetadata().timestamp()
                );
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println(
                        "Unable to send message: "
                        + message + ", cause: " + ex.getMessage()
                );
            }
        });
    }
}
