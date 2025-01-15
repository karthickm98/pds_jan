package com.karthick.pds_jan.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sample")
public class SampleController {
    @GetMapping("/hello/{n}/{x}")
    public String sayHello(@PathVariable("n") String n, @PathVariable("x") int x){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < x; i++){
            sb.append("hello " + n);
        }
        return sb.toString();

    }
    @GetMapping("/bye")
    public String bye(){
        return "bye";
    }
}
///*
//localhost -> 127.0.0.1
//port number as a entry where someone is listening for your request.
//
//http://localhost:2345/say/hello
//
//
//www.scaler.com/instructor/meetings/i/rest-apis-http-27/
//india/ banglore/ techpack/ scaler/door-33
//
//This domain name maps to some ip address: 123.12.13.122
//
// */