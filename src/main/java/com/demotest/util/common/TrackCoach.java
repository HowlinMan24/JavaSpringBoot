package com.demotest.util.common;

import jdk.jfr.Label;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("Inside constructor of TrackCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 20 minutes a hard 5k!";
    }
}
