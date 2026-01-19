package com.tekion.queue_implementation.producer.controller;


import com.tekion.queue_implementation.producer.model.Message;
import com.tekion.queue_implementation.producer.service.AddToQueue;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/message")
public class AddingMessages {

    @Autowired
    private AddToQueue addToQueue;

    @PostMapping
    public void addMessage(@RequestBody Message message) {
        addToQueue.addMessage(message);
    }

}
