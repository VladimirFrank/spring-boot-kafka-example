package ru.frank.springkafkaexample.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("kafka")
@ConstructorBinding
public class KafkaProperties {
    public String bootstrapAddress;
    public String topicName;
    public String groupId;

    public KafkaProperties(String bootstrapAddress, String topicName, String groupId) {
        this.bootstrapAddress = bootstrapAddress;
        this.topicName = topicName;
        this.groupId = groupId;
    }
}
