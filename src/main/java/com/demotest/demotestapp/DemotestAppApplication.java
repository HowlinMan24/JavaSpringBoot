package com.demotest.demotestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.demotest.demotestapp",
                "com.demotest.util"
        }
)
public class DemotestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotestAppApplication.class, args);
    }

}
