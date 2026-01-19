package com.tekion.queue_implementation.producer.mappings;

import com.tekion.queue_implementation.producer.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Topic {

    private String name;
    private List<Partition> partitions;

    public Topic(String name, int numberOfPartitions) {
        this.name = name ;
        partitions = new ArrayList<>();
        for (int i = 0; i < numberOfPartitions; i++) {
            partitions.add(new Partition());
        }
    }

    private int getPartitionIndex(String key) {
        return Math.abs(key.hashCode()) % partitions.size();
    }

    public Partition getPartition(String key) {
        int index = getPartitionIndex(key);
        return partitions.get(index);
    }

    public void addMessage(Message message) {
        Partition partition = getPartition(message.getKey());
        List<Message> messageList = partition.getMessages();
        System.out.println("message added to partition");
        messageList.add(message);
    }
}
