package com.tekion.queue_implementation.consumer.model;

import com.tekion.queue_implementation.producer.mappings.Partition;
import lombok.AllArgsConstructor;

import java.util.*;

@AllArgsConstructor
public class PartitionAssigner {

    private final List<Consumer> consumers;
    private int nextConsumerIndex = 0;

    public PartitionAssigner(List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public Consumer assignConsumer(Partition partition) {
        Consumer consumer = consumers.get(nextConsumerIndex);
        nextConsumerIndex = (nextConsumerIndex + 1) % consumers.size();

        consumer.getOffset().putIfAbsent(partition, 0);
        return consumer;
    }
}
