package com.aalvaropc.learnkafka.consumers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LearnConsumer {
    
    private static final Logger log = LoggerFactory.getLogger(LearnConsumer.class);
    public static void main(String[] args) {
        
        Properties props = new Properties();

        props.setProperty("bootstrap.servers", "localhost:9092");
        props.setProperty("group.id", "test");
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        try(KafkaConsumer<String, String>  consumer = new KafkaConsumer<>(props)){

            consumer.subscribe(Arrays.asList("aalvaropc"));
            while(true){
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofMillis(0));
                for(ConsumerRecord<String, String> consumerRecord : consumerRecords){
                    log.info("Offset = {}, Partition = {}, Key = {}, Value = {}", consumerRecord.offset(), consumerRecord.partition(), consumerRecord.key(), consumerRecord.value());
                }
            }
        }
    }
}
