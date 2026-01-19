package com.tekion.queue_implementation.producer.service;


import com.tekion.queue_implementation.producer.mappings.Topic;
import com.tekion.queue_implementation.producer.mappings.TopicsMapper;
import com.tekion.queue_implementation.producer.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddToQueue {

    @Autowired TopicsMapper topicsMapper;

    public void addMessage(Message message, String topicName) {
        Topic topic = topicsMapper.getTopic(topicName);
        topic.addMessage(message);
    }
}
