package it.academy.controller;

import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private SensorDao sensorDao;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Sensor> sensors = sensorService.findAll();
        model.addAttribute("sensors", sensors);
        return "home";
    }



}
