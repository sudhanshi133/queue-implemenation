package com.tekion.queue_implementation.consumer.model;

import com.tekion.queue_implementation.producer.mappings.Partition;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;

@Data
@AllArgsConstructor
public class Consumer {

    String consumerId;
    HashMap<Partition, Integer> offset = new HashMap<>();
 }
