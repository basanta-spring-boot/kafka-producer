package com.javatechie.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageConsumer {

    @Value("${app.topic.name}")
    private String topicName;

    @KafkaListener(topics = "${app.topic.name}", groupId = "jtc-group-12")
    public void consume(ConsumerRecord<String, String> payload) {
        log.info("Tópico: {}", topicName);
        log.info("key: {}", payload.key());
        log.info("Headers: {}", payload.headers());
        log.info("Partion: {}", payload.partition());
        log.info("Order: {}", payload.value());

    }


//    @KafkaListener(topics = "newTopic-2", groupId = "jtc-group-10")
//    public void consume_1_Events(String message) {
//        log.info("consume_1_Events : message consumed from kafka topic {} ", message);
//
//    }

//    @KafkaListener(topics = "javatechie-topic", groupId = "jtc-group-5")
//    public void consume_2_Events(String message) {
//        log.info("consume_2_Events : message consumed from kafka topic {} ", message);
//        sleepFor10Sec();
//    }
//
//    @KafkaListener(topics = "javatechie-topic", groupId = "jtc-group-5")
//    public void consume_3_Events(String message) {
//        log.info("consume_3_Events : message consumed from kafka topic {} ", message);
//        sleepFor10Sec();
//    }
//
//    @KafkaListener(topics = "javatechie-topic", groupId = "jtc-group-5")
//    public void consume_4_Events(String message) {
//        log.info("consume_4_Events : message consumed from kafka topic {} ", message);
//        sleepFor10Sec();
//    }
//
//    private void sleepFor10Sec(){
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}
