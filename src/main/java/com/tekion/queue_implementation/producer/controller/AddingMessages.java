package com.tekion.queue_implementation.producer.controller;


import com.tekion.queue_implementation.producer.mappings.Topic;
import com.tekion.queue_implementation.producer.model.Message;
import com.tekion.queue_implementation.producer.service.AddToQueue;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class AddingMessages {

    @Autowired
    private AddToQueue addToQueue;

    @PostMapping("/{topicName}")
    public String publish(@PathVariable String topicName, @RequestBody Message message) {
        addToQueue.addMessage(message, topicName);
        return "Message added to topic " + topicName;
    }
}
