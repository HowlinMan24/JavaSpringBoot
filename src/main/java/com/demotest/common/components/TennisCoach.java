package com.demotest.common.components;

import com.demotest.common.interfacesComponents.Coach;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    public TennisCoach() {
        System.out.println("Inside constructor of TennisCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 45 minutes training tennis";
    }
}
