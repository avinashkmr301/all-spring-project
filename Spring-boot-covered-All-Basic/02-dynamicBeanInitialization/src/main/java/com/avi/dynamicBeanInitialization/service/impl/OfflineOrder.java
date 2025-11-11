package com.avi.dynamicBeanInitialization.service.impl;

import com.avi.dynamicBeanInitialization.service.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("offlineOrderObject")
public class OfflineOrder implements Order {

    OfflineOrder(){
        System.out.println("OfflineOrder initialized...");
    }

    @Override
    public void createOrder() {
        System.out.println("created offLine order.");
    }
}
