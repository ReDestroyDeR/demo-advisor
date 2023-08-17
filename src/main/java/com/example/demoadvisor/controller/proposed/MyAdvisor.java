package com.example.demoadvisor.controller.proposed;

import com.example.demoadvisor.api.MyApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Component
@Profile({"x", "proposed"})
@RequiredArgsConstructor
public class MyAdvisor {

    private final MyApi real;

    public ResponseEntity<String> endpointA() {
        return ResponseEntity.badRequest().body("MyAdvisor A");
    }

    public ResponseEntity<String> endpointB() {
        return ResponseEntity.badRequest().body("MyAdvisor B");
    }
}
