package com.osckorea.springcloudfunctionexample;

import com.osckorea.springcloudfunctionexample.cloudStream.KafkaProducerApplication;
import com.osckorea.springcloudfunctionexample.kafka.KafkaResponseLogger;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import reactor.core.publisher.Flux;

import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
@AllArgsConstructor
public class SpringCloudFunctionExampleApplication {

    private final KafkaProducerApplication kafkaProducerApplication;

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudFunctionExampleApplication.class, args);
    }

    // FUNCTION 생성
    // 두 개의 파라메터를 사용, value 값을 대문자로 반환한다, toUpperCase는 서버리스 함수로 사용된다.
    // Bean 어노테이션을 사용해서 기능으로 등록해서 사용하면 된다.
    // 특정 이름을 대문자로 사용하여 이 함수를 호출 할 수 있다.
    @Bean

    public Function<String, String> toUpperCase() {
//        return (value) -> new StringBuilder(value).toString().toUpperCase();
        return (value) -> {
            String response = new StringBuilder(value).toString().toUpperCase();
            kafkaProducerApplication.sendToKafka(response);
            return response;
        };
    }



    // Supplier 인터페이스는 매개변수를 받지 않고 단순한 결과 값을 제공하는 함수형 인터페이스
    @Bean
    public Supplier<String> getMessage() {
        return () -> "Welcome to Spring Cloud Function Supplier interface";
    }

    @Bean
    public Consumer<String> writerMessage() {
        return (value) -> System.out.println(value);
    }
    // function, Supplier, consumer 모두 사용하기 때문에 curl을 사용하여 함수를 호출할 수 있다.
}
