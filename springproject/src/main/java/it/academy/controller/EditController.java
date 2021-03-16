package it.academy.controller;

import it.academy.model.Sensor;
import it.academy.service.SensorService;
import it.academy.service.TypeService;
import it.academy.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class EditController {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private UnitService unitService;

    @GetMapping("/sensor-edit/{id}")
    public String editSensorForm(@PathVariable("id") Integer id,
                                 Model model1, Model model2, Model model3) {
        model3.addAttribute("sensor", sensorService.findById(id));
        model1.addAttribute("types", typeService.findAll());
        model2.addAttribute("units", unitService.findAll());
        return "sensor-update";

    }

    @PostMapping("/sensor-edit/{id}")
    public String editSensor(@ModelAttribute(name = "sensor") Sensor sensor,
                             @PathVariable Integer id, Model model1, Model model2) {
        model1.addAttribute("types", typeService.findAll());
        model2.addAttribute("units", unitService.findAll());
        sensor.setId(id);
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }

}
