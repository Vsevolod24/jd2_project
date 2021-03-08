package it.academy.controller;

import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import it.academy.service.PageService;
import it.academy.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class HomeController {

    private final PageService pageService;

    private final SensorService sensorService;


    @Autowired
    public HomeController(PageService pageService, SensorService sensorService) {
        this.pageService = pageService;
        this.sensorService = sensorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listSensors(Model model,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {

        Iterable<Sensor> sensors = sensorService.findAll();
        model.addAttribute("sensors", sensors);

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Sensor> sensorPage =
                pageService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("sensorPage", sensorPage);

        int totalPages = sensorPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "home";

    }

}
