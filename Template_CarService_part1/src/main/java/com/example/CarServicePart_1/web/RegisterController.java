package com.example.CarServicePart_1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.CarServicePart_1.domain.Car;

@Controller
public class RegisterController {
    @RequestMapping("/register")
    public String getRegistrationPage() {
        // Write your Logic
        return "carregister";
    }

}