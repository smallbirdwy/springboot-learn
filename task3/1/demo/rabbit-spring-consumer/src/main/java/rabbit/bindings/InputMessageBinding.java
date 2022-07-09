package rabbit.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface InputMessageBinding {

    String INPUT = "message-mq";

    @Input(INPUT)
    SubscribableChannel input();
}
