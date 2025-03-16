package com.avi.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @GetMapping("/hello")
    public String helloWorld(Model model){
        model.addAttribute("theDate", java.time.LocalDateTime.now());
        return "helloWorld";
    }
}
