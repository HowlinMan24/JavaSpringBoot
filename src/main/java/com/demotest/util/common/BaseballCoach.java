package com.demotest.util.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach  {

    public BaseballCoach() {
        System.out.println("Inside constructor of baseballCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice.";
    }
}
