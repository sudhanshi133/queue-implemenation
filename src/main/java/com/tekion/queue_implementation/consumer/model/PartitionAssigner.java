package com.tekion.queue_implementation.consumer.model;

import com.tekion.queue_implementation.producer.mappings.Partition;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@AllArgsConstructor
public class PartitionAssigner {

    private final List<Consumer> consumers;
    private int nextConsumerIndex = 0;

    public PartitionAssigner(ConsumerRegistry registry) {
        this.consumers = registry.getConsumers();
    }

    public Consumer assignConsumer(Partition partition) {
        Consumer consumer = consumers.get(nextConsumerIndex);
        nextConsumerIndex = (nextConsumerIndex + 1) % consumers.size();

        consumer.getOffset().putIfAbsent(partition, 0);
        return consumer;
    }
}
