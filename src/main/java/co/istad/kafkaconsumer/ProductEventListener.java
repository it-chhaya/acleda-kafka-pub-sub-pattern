package co.istad.kafkaconsumer;

import co.istad.kafkaconsumer.event.MessageEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventListener {

    @KafkaListener(topics = "user-created-event-topic", groupId = "test")
    public void consume(MessageEvent messageEvent) {
        System.out.println("From Kafka: " + messageEvent);
        //TODO
    }

}
