package com.demotest.common.components;

import com.demotest.common.interfacesComponents.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * This is a `Component Class` suggested by the `@Component` annotation. This is generated during the creation of the app
 * The `@PostConstruct` method runs right after the starting of the app and executes its containment.
 * The `@PreDestroy` method runs right before the destruction of the app(This is when you stop the app or crashes etc.) and executes its containment.
 */

@Component
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("Inside constructor of baseballCoach");
    }


    // Define our init method

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
