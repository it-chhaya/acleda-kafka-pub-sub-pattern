package co.istad.kafkaconsumer.event;

public record Message(
        String id,
        String title,
        String message,
        String thumbnail
) {
}
