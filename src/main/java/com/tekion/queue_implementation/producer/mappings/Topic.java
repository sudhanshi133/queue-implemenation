package com.tekion.queue_implementation.producer.mappings;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Topic {

    private String name;
    private List<Partition> partitions;
}
