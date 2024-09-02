package com.demotest.demotestapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
        scanBasePackages = {
                "com.demotest.demotestapp",
                "com.demotest.util",
                "com.demotest.config"
        }
)
public class DemotestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotestAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return runner -> System.out.println("Hello World");
    }


}
