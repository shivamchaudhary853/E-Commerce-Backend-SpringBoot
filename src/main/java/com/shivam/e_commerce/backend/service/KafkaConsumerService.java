package com.shivam.e_commerce.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    @KafkaListener(
            topics = "order-topic",
            groupId = "order-group"
    )

    public void consume(String message){
        System.out.println(
                "Kafka Message Recieved:" + message
        );
    }
}
