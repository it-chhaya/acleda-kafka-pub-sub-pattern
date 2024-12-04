package co.istad.kafkaconsumer;

import co.istad.kafkaconsumer.event.Message;
import co.istad.kafkaconsumer.event.MessageEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProducerController {

    private final KafkaTemplate<String, MessageEvent> kafkaTemplate;

    @PostMapping("/messages")
    Map<String, MessageEvent> produceMessage(@RequestBody MessageEvent message) {
        kafkaTemplate.send("user-created-event-topic",
                "message",
                message);
        return Map.of("message", message);
    }

}
