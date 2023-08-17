package com.example.demoadvisor.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/demo")
public interface MyApi {

    @GetMapping
    ResponseEntity<String> endpointA();

    @PostMapping
    ResponseEntity<String> endpointB();

}
