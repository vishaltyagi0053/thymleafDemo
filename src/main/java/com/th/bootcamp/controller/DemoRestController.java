package com.th.bootcamp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

    @RequestMapping("/")
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Jha ji";
    }
}
