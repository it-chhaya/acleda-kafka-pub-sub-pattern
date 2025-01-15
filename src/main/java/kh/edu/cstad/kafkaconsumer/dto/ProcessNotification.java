package kh.edu.cstad.kafkaconsumer.dto;

import java.time.LocalDateTime;

public record ProcessNotification(
        String message,
        LocalDateTime timestamp
) {
}
