package com.example.CarService.Controller;

import com.example.CarService.domain.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarController {

    @RequestMapping("/")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/register")
    public String registerCar(ModelMap map){
        map.addAttribute("car",new Car());
        return "carregister";
    }

    @GetMapping("/example")
    public ModelAndView example() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("carregister"); // Set the view name
        modelAndView.addObject("car", new Car()); // Add model data
        return modelAndView;
    }

}
