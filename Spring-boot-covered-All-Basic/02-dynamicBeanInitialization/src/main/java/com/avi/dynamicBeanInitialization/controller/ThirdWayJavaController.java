package com.avi.dynamicBeanInitialization.controller;

import com.avi.dynamicBeanInitialization.thirdway.Vehical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/java")
public class ThirdWayJavaController {

    @Autowired
    private Vehical vehical;


    @PostMapping("/bookRide")
    public ResponseEntity<String> bookRide(){
        vehical.booking();

        return ResponseEntity.ok("");
    }

}
