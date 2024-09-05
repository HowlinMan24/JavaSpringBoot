package com.demotest.common.components;

import com.demotest.common.interfacesComponents.Coach;


public class SwimCoach implements Coach {

    public SwimCoach() {
        System.out.println("Inside SwimCoach");
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 20 laps around the pool!!!";
    }
}
