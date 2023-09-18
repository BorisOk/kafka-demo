package by.boris.kafkademo.consumer;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class Consumer {
    @KafkaListener(topics = "test_topic", groupId = "group_id")
    public void consumeMessage(String message) {
        log.warn("consumer:consumeMessage -> message:{}", message);
    }
}
