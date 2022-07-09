package com.rabbit.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputMessageBinding {
    String OUTPUT = "message-mq";

    @Output(OUTPUT)
    MessageChannel output();
}
