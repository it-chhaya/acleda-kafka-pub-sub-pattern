package kh.edu.cstad.kafkaconsumer;

import kh.edu.cstad.kafkaconsumer.event.BaseEvent;
import kh.edu.cstad.kafkaconsumer.event.Notification;
import kh.edu.cstad.kafkaconsumer.event.NotificationEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProducerController {

//    private final KafkaTemplate<String, Map<String, Object>> kafkaTemplate;
//
//    @PostMapping("/messages")
//    Map<String, Notification> produceMessage(@RequestBody Notification notification) {
//
//        Map<String, Object> payload = new HashMap<>();
//        payload.put("notification", notification);
//
//        Message<Map<String, Object>> message = MessageBuilder
//                .withPayload(payload)
//                .setHeader(KafkaHeaders.TOPIC, "notifications")
//                .build();
//
//        kafkaTemplate.send(message);
//
//        return null;
//    }

//    private final KafkaTemplate<String, NotificationEvent> kafkaTemplate;
//
//    @PostMapping("/notification")
//    public void send() {
//        NotificationEvent notification = new NotificationEvent();
//        notification.setMessage("Hello World");
//        notification.setId("NOTIFICATION_ID");
//        notification.setType("INFO");
//        kafkaTemplate.send("notificationEventsTopic", notification.getId(), notification);
//    }

}
