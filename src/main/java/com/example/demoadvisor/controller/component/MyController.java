package com.example.demoadvisor.controller.component;

import com.example.demoadvisor.api.MyApi;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("component")
public class MyController implements MyApi {

    @Override
    public ResponseEntity<String> endpointA() {
        return ResponseEntity.ok("MyController A");
    }

    @Override
    public ResponseEntity<String> endpointB() {
        return ResponseEntity.ok("MyController B");
    }
}
