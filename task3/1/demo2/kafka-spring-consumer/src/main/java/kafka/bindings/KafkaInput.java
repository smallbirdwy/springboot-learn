package kafka.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface KafkaInput {
    String INPUT = "kafka-message";

    @Input(INPUT)
    SubscribableChannel input();
}
