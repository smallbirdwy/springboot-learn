package kafka.bindings;


import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaOutput {
    String OUTPUT = "kafka-message";

    @Output(OUTPUT)
    MessageChannel output();
}
