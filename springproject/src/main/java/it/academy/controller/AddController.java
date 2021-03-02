package it.academy.controller;

import it.academy.model.Sensor;
import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddController {

    private final SensorService sensorService;

    @Autowired
    public AddController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/add_sensor")
    public String createSensorForm(Sensor sensor) {
        return "add";
    }

    @PostMapping("/add_sensor")
    public String createSensor(Sensor sensor){
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }

    @GetMapping("sensor-delete/{id}")
    public String deleteSensor(@PathVariable("id") Long id){
        sensorService.deleteById(id);
        return  "redirect:/";
    }

    @GetMapping("/sensor-edit/{id}")
    public String editSensorForm(@PathVariable("id") Long id, Model model) {
        Sensor sensor = sensorService.findById(id);
        model.addAttribute("sensors", sensor);
        return "sensor-update";
    }

    @PostMapping("/sensor-edit")
    public String editSensor(Sensor sensor){
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }

}