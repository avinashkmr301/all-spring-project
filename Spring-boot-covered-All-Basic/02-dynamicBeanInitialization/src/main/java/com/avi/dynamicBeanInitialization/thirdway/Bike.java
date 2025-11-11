package com.avi.dynamicBeanInitialization.thirdway;

import org.springframework.stereotype.Component;


public class Bike implements Vehical{

    public Bike(){
        System.out.println("Bike bean initialized...");
    }

    @Override
    public void booking() {
        System.out.println("Bike is Booked.");
    }
}
