package kh.edu.cstad.kafkaconsumer.event;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Notification extends BaseEvent {

    private String id;
    private String message;
    private String type;
    private String userId;
    private Instant timestamp;
    private boolean read;

}
