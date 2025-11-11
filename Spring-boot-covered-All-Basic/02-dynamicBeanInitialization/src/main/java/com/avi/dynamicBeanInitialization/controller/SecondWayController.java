package com.avi.dynamicBeanInitialization.controller;

import com.avi.dynamicBeanInitialization.service.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secondWay")
public class SecondWayController {

    @Autowired
    @Qualifier("onlineOrderObject")
    public Order onlineOrder;

    @Autowired
    @Qualifier("offlineOrderObject")
    public Order offlineOrder;

    @PostMapping("createOrder")
    public ResponseEntity<String> createOrder(@RequestParam boolean isOnlineOrder){

        if (isOnlineOrder){
            onlineOrder.createOrder();
        }else {
            offlineOrder.createOrder();
        }

        return ResponseEntity.ok("");

    }
}


