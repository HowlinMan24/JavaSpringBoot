package com.demotest.util.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("Inside constructor of baseballCoach");
    }


    // Define out init method

    @PostConstruct
    public void init() {
        System.out.println("Inside init of baseballCoach");
    }

    // Define our destroy method

    @PreDestroy
    public void destroy() {
        System.out.println("Inside destroy of baseballCoach");
    }


    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice.";
    }
}
