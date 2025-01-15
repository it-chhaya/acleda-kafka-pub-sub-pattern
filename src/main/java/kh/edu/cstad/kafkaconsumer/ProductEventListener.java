package kh.edu.cstad.kafkaconsumer;

import kh.edu.cstad.kafkaconsumer.event.Order;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventListener {

//    @KafkaListener(topics = "notificationEventsTopic", groupId = "${spring.application.name}")
//    public void consume(GenericRecord record) {
//        System.out.println("From Kafka: " + record);
//        //TODO
//    }

//    @KafkaListener(topics = "orders_spooldir_00", groupId = "${spring.application.name}")
//    public void consumeExcel(ConsumerRecord<String, Order> data) {
//        System.out.println("Data: " + data.value());
//    }

}
