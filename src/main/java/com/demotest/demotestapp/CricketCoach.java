package com.demotest.demotestapp;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "The daily workout is 15 minutes";
    }
}
