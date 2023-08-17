package com.example.demoadvisor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoAdvisorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAdvisorApplication.class, args);
    }

}
