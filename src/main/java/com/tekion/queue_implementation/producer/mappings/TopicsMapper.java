package com.tekion.queue_implementation.producer.mappings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TopicsMapper {

    private final Map<String, Topic> topics = new HashMap<>();

    public TopicsMapper() {
        topics.put("topic-1", new Topic("topic-1", 5));
        topics.put("topic-2", new Topic("topic-2", 5));
        topics.put("topic-3", new Topic("topic-3", 5));
    }

    public Topic getTopic(String topicName) {
        Topic topic = topics.get(topicName);
        if (topic == null) {
            throw new IllegalArgumentException("Topic not found");
        }
        return topic;
    }
}
