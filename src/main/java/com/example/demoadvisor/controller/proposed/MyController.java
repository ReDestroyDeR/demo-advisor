package com.example.demoadvisor.controller.proposed;

import com.example.demoadvisor.api.MyApi;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@Profile("proposed")
public class MyController extends AdvisorHelper<MyAdvisor> implements MyApi {

    public MyController(MyAdvisor advisor) {
        super(advisor);
    }

    @Override
    public ResponseEntity<String> endpointA() {
        return advice(
                new Random()::nextBoolean,
                MyAdvisor::endpointA,
                () -> ResponseEntity.ok("MyController A")
        );
    }

    @Override
    public ResponseEntity<String> endpointB() {
        return advice(
            new Random()::nextBoolean,
            MyAdvisor::endpointB,
            () -> ResponseEntity.ok("MyController B")
    );
    }
}
