package com.shivam.e_commerce.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String , String> kafkaTemplate;


    public void SendMessage(String Message){
        kafkaTemplate.send("order-topic",Message);
    }
}
