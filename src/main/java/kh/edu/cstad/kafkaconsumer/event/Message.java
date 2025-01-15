package kh.edu.cstad.kafkaconsumer.event;

public record Message(
        String id,
        String title,
        String message,
        String thumbnail
) {
}
