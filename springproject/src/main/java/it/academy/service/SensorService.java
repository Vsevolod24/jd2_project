package it.academy.service;

import it.academy.dao.PageDao;
import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    private SensorDao sensorDao;

    @Autowired
    public SensorService(SensorDao sensorDao, PageDao pageDao) {
        this.sensorDao = sensorDao;
    }

    public SensorService(String name, String model, String rangeFrom,
                         String rangeTo, String description, String location) {
    }

    public Sensor findById(Integer id) {
        return sensorDao.findById(id).orElseThrow(() -> new IllegalArgumentException("sensor id not found"));
    }

    public List<Sensor> findAll() {
        return sensorDao.findAll();
    }

    public Sensor saveSensor(Sensor sensor) {
        return sensorDao.save(sensor);
    }

    public void deleteById(Integer id) {
        sensorDao.deleteById(id);
    }


}

