package com.rabbit.controller;

import com.rabbit.bindings.OutputMessageBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableBinding(OutputMessageBinding.class)
public class RabbitController {

    @Autowired
    OutputMessageBinding messageBinding;

    @GetMapping("/message")
    public void send(){
        System.out.println("message = " + "hello rabbitmq");
        messageBinding.output().send(MessageBuilder.withPayload("hello rabbitmq").build());
    }
}
