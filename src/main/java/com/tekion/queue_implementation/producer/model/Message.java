package com.tekion.queue_implementation.producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private String key;
    private String value;
    private long timestamp;

}

