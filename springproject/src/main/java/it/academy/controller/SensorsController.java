package it.academy.controller;

import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SensorsController {

    @Autowired
    private SensorDao sensorDao;

    @Autowired
    private SensorService sensorService;

    @GetMapping("/sensors")
    public String support(Model model) {
        Iterable<Sensor> sensors = sensorDao.findAll();
        model.addAttribute("sensors", sensors);
        return "sensors";
    }

}
