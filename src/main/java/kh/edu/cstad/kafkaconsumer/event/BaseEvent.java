package kh.edu.cstad.kafkaconsumer.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Notification.class, name = "NOTIFICATION_CREATED"),
})
@Getter
@Setter
public abstract class BaseEvent {

    private String eventId;
    private Instant timestamp;
    private String version;
    private String source;

}
