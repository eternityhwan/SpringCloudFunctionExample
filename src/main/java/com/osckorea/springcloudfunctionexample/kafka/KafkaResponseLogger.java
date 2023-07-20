package com.osckorea.springcloudfunctionexample.kafka;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KafkaResponseLogger {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void logResponse(String response) {
        kafkaTemplate.send("exam", response);
    }
}
