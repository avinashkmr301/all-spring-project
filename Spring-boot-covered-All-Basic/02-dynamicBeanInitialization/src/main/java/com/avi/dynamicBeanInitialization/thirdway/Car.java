package com.avi.dynamicBeanInitialization.thirdway;

import org.springframework.stereotype.Component;

public class Car implements Vehical{

    public Car(){
        System.out.println("Car bean initialized...");
    }

    @Override
    public void booking() {
        System.out.println("Car is booked.");
    }
}
