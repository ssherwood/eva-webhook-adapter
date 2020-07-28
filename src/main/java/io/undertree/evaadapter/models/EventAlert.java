package io.undertree.evaadapter.models;

import lombok.Data;

@Data
public class EventAlert {
    String publisher;
    String topic;
    String timestamp;
    String subject;
    String body;
    EventAlertMetadata metadata;
}
