package it.academy.service;

import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {


    private SensorDao sensorDao;

    @Autowired
    public SensorService(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }

    public SensorService(String name, String model, String rangeFrom, String rangeTo, String description) {
    }

    public Sensor findById(Long id) {
        return sensorDao.getOne(id);
    }

    public List<Sensor> findAll() {
        return sensorDao.findAll();
    }

    public Sensor saveSensor(Sensor sensor) {
        return sensorDao.save(sensor);
    }

    public void deleteById(Long id) {
        sensorDao.deleteById(id);
    }

}
