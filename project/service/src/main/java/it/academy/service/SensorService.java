package it.academy.service;

import it.academy.dao.SensorDao;
import it.academy.model.Sensor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@ToString
@Service("sensorService")
public class SensorService {

    @Autowired
    @Qualifier("sensorDaoImpl")
    private SensorDao sensorDao;


    public List<Sensor> findAllSensors(){
        return sensorDao.findAllSensors();
    }
}