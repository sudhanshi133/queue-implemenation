package com.tekion.queue_implementation.consumer.api;

import com.tekion.queue_implementation.consumer.model.Consumer;
import com.tekion.queue_implementation.consumer.model.PartitionAssigner;
import com.tekion.queue_implementation.producer.mappings.Partition;
import com.tekion.queue_implementation.producer.model.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MessageMonitor implements Runnable {

    private final Map<Partition, List<Message>> partitionData;
    private final PartitionAssigner partitionAssigner;

    public MessageMonitor(
            Map<Partition, List<Message>> partitionData,
            PartitionAssigner partitionAssigner
    ) {
        this.partitionData = partitionData;
        this.partitionAssigner = partitionAssigner;
    }

    @Override
    public void run() {
        while (true) {
            for (Partition partition : partitionData.keySet()) {

                List<Message> messages = partitionData.get(partition);

                Consumer consumer = partitionAssigner.assignConsumer(partition);
                int lastOffset = consumer.getOffset().get(partition);

                // Check if new message exists
                if (messages.size() > lastOffset) {

                    Message newMessage = messages.get(lastOffset);

                    processMessage(consumer, newMessage, partition);

                    // Update offset
                    consumer.getOffset().put(partition, lastOffset + 1);
                }
            }
            //todo backpressure
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    private void processMessage(Consumer consumer, Message message, Partition partition) {
        Integer currentOffset = consumer.getOffset().get(partition);
        consumer.getOffset().put(partition, currentOffset + 1);
        System.out.println("Consumer " + consumer.getConsumerId() + "message: "+ message.getValue());
    }
}

