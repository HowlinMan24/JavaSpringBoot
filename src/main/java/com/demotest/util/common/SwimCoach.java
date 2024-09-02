package com.demotest.util.common;

import org.springframework.stereotype.Component;


public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside SwimCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 20 laps around the pool!!!";
    }
}
