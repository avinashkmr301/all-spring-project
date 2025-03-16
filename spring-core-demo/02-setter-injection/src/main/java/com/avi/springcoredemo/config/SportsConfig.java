package com.avi.springcoredemo.config;

import com.avi.springcoredemo.commons.Coach;
import com.avi.springcoredemo.commons.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsConfig {

    @Bean
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
