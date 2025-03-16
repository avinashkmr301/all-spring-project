package com.avi.springcoredemo.commons;

import org.springframework.stereotype.Component;

@Component
public class CricketClub implements Coach{
    @Override
    public String getDailyWorkOut() {
        return "Practice high speed bowling for 15 minutes!";
    }
}
