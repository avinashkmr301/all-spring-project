package com.avi.dynamicBeanInitialization.service.impl;

import com.avi.dynamicBeanInitialization.service.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("onlineOrderObject")
//@Primary   // either we can use primary or @Qualifier
public class OnlineOrder implements Order {

    OnlineOrder(){
        System.out.println("Online order initialized...");
    }

    @Override
    public void createOrder() {
        System.out.println("created online order.");
    }
}
