package com.aalvaropc.learnkafka.multithread;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.aalvaropc.learnkafka.consumers.LearnConsumer;

public class LearnThreadConsumer extends Thread {
    private final KafkaConsumer<String, String> consumer;

    private final AtomicBoolean closed = new AtomicBoolean(false);

     private static final Logger log = LoggerFactory.getLogger(LearnThreadConsumer.class);

    public LearnThreadConsumer(KafkaConsumer<String, String> consumer) {
        this.consumer = consumer;

    }

    @Override
    public void run() {
        consumer.subscribe(Arrays.asList("aalvaropc"));
        try {
            while (!closed.get()) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    log.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
                }
            }
            
        } catch (WakeupException e) {
            if (!closed.get()) throw e;
        } finally {
            consumer.close();
        }
    }

    public void shutdown() {
        closed.set(true);
        consumer.wakeup();
    }
}
