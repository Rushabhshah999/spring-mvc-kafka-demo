package com.company;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserConsumer {

    @KafkaListener(
            topics = "user-topic",
            groupId = "my-group",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(User.UserDetails userDetails) {
        System.out.println("Consumed userDetails: " + userDetails);
    }

}