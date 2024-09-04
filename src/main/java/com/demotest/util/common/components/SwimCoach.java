package com.demotest.util.common.components;

import com.demotest.util.common.interfacesComponents.Coach;


public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside SwimCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 20 laps around the pool!!!";
    }
}
