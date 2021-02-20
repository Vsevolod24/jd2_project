package it.academy.web.controller;

import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class HomeController {

    public static final Logger log = Logger.getLogger(it.academy.web.controller.HomeController.class.getName());

    @Autowired
    SensorService sensorService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("sensorList", sensorService.findAllSensors());
        return "index";
    }
}


