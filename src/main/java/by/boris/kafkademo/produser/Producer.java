package by.boris.kafkademo.produser;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class Producer {
    private static final String TOPIC = "test_topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.warn("producer:sendMessage -> message:{}", message);
        this.kafkaTemplate.send(TOPIC, message);
    }

    @Bean
    public NewTopic createTopic() {
        return new NewTopic(TOPIC, 3, (short) 1);
    }
}
