package com.demotest.controllers.rest;

import com.demotest.common.interfacesComponents.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;

    @Autowired
    public DemoController(@Qualifier("aquatic") Coach myCoach) {
        this.myCoach = myCoach;
        System.out.println("Inside constructor: " + getClass().getSimpleName());
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
