package kafka.controller;

import kafka.bindings.KafkaOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(KafkaOutput.class)
public class SendMessageController {

    @Autowired
    KafkaOutput kafkaOutput;

    @GetMapping("/message")
    public void send(){
        System.out.println("message = " + "hello kafka");
        kafkaOutput.output().send(MessageBuilder.withPayload("hello kafka").build());
    }


}
