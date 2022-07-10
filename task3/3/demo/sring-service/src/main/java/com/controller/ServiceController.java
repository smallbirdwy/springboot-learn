package com.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

    @GetMapping("/{id}")
    public void test(Long id){
        System.out.println("zk coming ..... " + id);
    }
}
