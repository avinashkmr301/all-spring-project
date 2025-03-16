package com.avi.springcoredemo.rest;

import com.avi.springcoredemo.commons.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach coach;
    @Autowired
    private void setCoach(@Qualifier("swimCoach") Coach coach1){
        this.coach = coach1;
    }

    @GetMapping("/daily-workout")
    public String getDailyWorkout(){
        return coach.getDailyWorkOut();
    }
}
