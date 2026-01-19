package com.tekion.queue_implementation.producer.mappings;

import com.tekion.queue_implementation.producer.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partition {
    private List<Message> messages = new ArrayList<>();
}
