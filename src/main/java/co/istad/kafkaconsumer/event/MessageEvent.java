package co.istad.kafkaconsumer.event;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageEvent {
    private String id;
    private String title;
    private String message;
    private String thumbnail;
}
