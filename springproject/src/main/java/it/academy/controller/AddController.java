package it.academy.controller;

import it.academy.model.Sensor;
import it.academy.service.SensorService;
import it.academy.service.TypeService;
import it.academy.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class AddController {

    private final TypeService typeService;

    private final UnitService unitService;

    private final SensorService sensorService;

    @Autowired
    public AddController(TypeService typeService, UnitService unitService, SensorService sensorService) {
        this.typeService = typeService;
        this.unitService = unitService;
        this.sensorService = sensorService;
    }

    @GetMapping("/add_sensor")
    public String createSensorForm(Model model1, Model model2, Model model3) {
        model1.addAttribute("types", typeService.findAll());
        model2.addAttribute("units", unitService.findAll());
        model3.addAttribute("sensor", new Sensor());
        return "add";
    }

    @PostMapping("/add_sensor")
    public String createSensor(@ModelAttribute(name = "sensor") Sensor sensor) {
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }

    @GetMapping("sensor-delete/{id}")
    public String deleteSensor(@PathVariable("id") Integer id) {
        sensorService.deleteById(id);
        return "redirect:/";
    }

}