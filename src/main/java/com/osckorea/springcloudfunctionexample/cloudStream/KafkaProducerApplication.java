package com.osckorea.springcloudfunctionexample.cloudStream;

import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class KafkaProducerApplication {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerApplication(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(String message) {
        kafkaTemplate.send("exam", message);
    }
}
