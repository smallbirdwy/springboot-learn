package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApolloController {
    @RequestMapping("/index")
    public String hello(){
        return "hello apollo";
    }
}
