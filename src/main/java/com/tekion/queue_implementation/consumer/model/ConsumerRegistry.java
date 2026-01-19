package com.tekion.queue_implementation.consumer.model;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ConsumerRegistry {

    private final List<Consumer> consumers = new ArrayList<>();

    public ConsumerRegistry() {
        consumers.add(new Consumer("A", new HashMap<>()));
        consumers.add(new Consumer("B", new HashMap<>()));
        consumers.add(new Consumer("C", new HashMap<>()));
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }
}
