package com.xiaomi.message.test.kafka.bean;

import lombok.Data;

@Data
public class KafkaTopicBean {
    private String topicName;
    private String partition;
    private String replication;
    private String descrbe;
}
