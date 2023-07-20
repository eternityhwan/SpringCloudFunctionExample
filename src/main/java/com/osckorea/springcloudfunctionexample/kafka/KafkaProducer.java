package com.osckorea.springcloudfunctionexample.kafka;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class KafkaProducer {
    // 프로듀서 클래스
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send("exam", message);
    }
}
