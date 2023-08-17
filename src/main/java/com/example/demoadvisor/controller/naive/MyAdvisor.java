package com.example.demoadvisor.controller.naive;

import com.example.demoadvisor.api.MyApi;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Primary
@RestController
@Profile({"x", "naive"})
@RequiredArgsConstructor
public class MyAdvisor implements MyApi {

    private final MyApi real;

    @Override
    public ResponseEntity<String> endpointA() {
        return new Random().nextBoolean()
                ? real.endpointA()
                : ResponseEntity.badRequest().body("MyAdvisor A");
    }

    @Override
    public ResponseEntity<String> endpointB() {
        return new Random().nextBoolean()
                ? real.endpointB()
                : ResponseEntity.badRequest().body("MyAdvisor B");
    }
}
