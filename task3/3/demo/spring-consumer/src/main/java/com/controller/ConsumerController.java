package com.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ConsumerController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired(required = true)
    RestTemplate restTemplate;

    @GetMapping("/")
    public void test(Long id){
        discoveryClient.getInstances("waiter-service").forEach(s -> {
            log.info("Host: {}, Port: {}", s.getHost(), s.getPort());
        });

        restTemplate.getForEntity("http://localhost:9090/1",String.class);
    }
}
