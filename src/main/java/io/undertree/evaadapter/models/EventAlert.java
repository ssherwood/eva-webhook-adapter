package io.undertree.evaadapter.models;

import lombok.Data;

import java.util.Map;

@Data
public class EventAlert {
    String publisher;
    String topic;
    String timestamp;
    Map<String, String> metadata;
    String subject;
    String body;
}
