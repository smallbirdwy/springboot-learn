package com.spring.task.springbucks.controller;

import com.spring.task.springbucks.model.Coffee;
import com.spring.task.springbucks.service.CoffeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {


    @Autowired
    CoffeeService coffeeService;
    @GetMapping(value = "/{id}", produces = "application/json")
    public Coffee findById(@PathVariable("id") Long id){
        Coffee coffee = coffeeService.findById(id);
        return coffee;
    }
    @GetMapping(value = "/xml/{id}", produces = "application/xml")
    public Coffee findByIdXml(@PathVariable("id") Long id){
        Coffee coffee = coffeeService.findById(id);
        return coffee;
    }
}
