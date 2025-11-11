package com.avi.dynamicBeanInitialization.config;

import com.avi.dynamicBeanInitialization.thirdway.Bike;
import com.avi.dynamicBeanInitialization.thirdway.Car;
import com.avi.dynamicBeanInitialization.thirdway.Vehical;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Vehical createVehicleBean(@Value("${isCarBooked}")boolean isCarBooking){

        if (isCarBooking){
            return new Car();
        }else {
            return new Bike();
        }
    }
}
