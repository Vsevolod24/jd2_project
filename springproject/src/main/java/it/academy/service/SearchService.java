package it.academy.service;

import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private SensorDao sensorDao;

    @Autowired
    public SearchService(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    public List<Sensor> searchSernsors(String param) {
        return sensorDao.findAll()
                .stream().filter(sensor -> sensor.getName().contains(param)
                    || sensor.getModel().contains(param))
                .collect(Collectors.toList());

    }

}
