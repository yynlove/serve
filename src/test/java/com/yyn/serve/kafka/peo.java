package com.yyn.serve.kafka;

import kafka.Kafka;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class peo {


    public static void main(String[] args) {

        //配置
        final Properties kfapro = new Properties();

        kfapro.put("bootstrap.servers","127.0.0.1:9092");
        kfapro.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        kfapro.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");
        final KafkaProducer<Object, String> producer = new KafkaProducer<>(kfapro);
        final ProducerRecord<Object, String> record = new ProducerRecord<>("主题1", "key1","value1");

        try {
            final RecordMetadata recordMetadata = producer.send(record).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

}
