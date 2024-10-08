package com.demotest.common.components;

import com.demotest.common.interfacesComponents.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("Inside constructor of CricketCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "The daily workout is 15 minutes";
    }
}
