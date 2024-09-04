package com.demotest.util.common.components;

import com.demotest.util.common.interfacesComponents.Coach;
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
