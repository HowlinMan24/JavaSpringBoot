package com.demotest.util.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Spend 20 minutes a hard 5k!";
    }
}
