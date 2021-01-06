package com.xiaomi.message.test.kafka.util;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaUtil {

    public static void createKafkaTopic(String topicName){
        Properties props = new Properties();
        props.put("bootstrap.servers", "182.92.196.143:9092");
        props.put("acks","all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms",1);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());

        AdminClient client = KafkaAdminClient.create(props);
        NewTopic topic = new NewTopic(topicName, 5,(short) 1);
        client.createTopics(Arrays.asList(topic));
        client.close();
    }

    public static void main(String[] args) {
        KafkaUtil.createKafkaTopic("test1");
        System.out.println("create topic success!");
    }
}
