package com.avi.springcoredemo.commons;

import org.springframework.stereotype.Component;


public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In Constructor "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkOut() {
        return "Swim 1000 meter for warmup!";
    }
}
