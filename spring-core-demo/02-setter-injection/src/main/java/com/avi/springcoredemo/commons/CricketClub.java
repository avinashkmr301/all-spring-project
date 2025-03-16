package com.avi.springcoredemo.commons;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class CricketClub implements Coach{
    public CricketClub(){
        System.out.println("Cricket-Bean");
    }
    @Override
    public String getDailyWorkOut() {
        return "Practice high speed bowling for 15 minutes!!";
    }
}
