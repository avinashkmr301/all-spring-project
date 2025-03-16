package com.avi.springcoredemo.commons;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach{
    public BaseBallCoach(){
        System.out.println("BaseBall-Bean");
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice BaseBall for 20 minutes!!!";
    }
}
