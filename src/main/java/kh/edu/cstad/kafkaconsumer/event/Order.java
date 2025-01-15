package kh.edu.cstad.kafkaconsumer.event;

public record Order(
        String order_id,
        String customer_id
) {
}
