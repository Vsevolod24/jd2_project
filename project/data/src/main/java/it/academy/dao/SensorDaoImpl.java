package it.academy.dao;


import it.academy.model.Sensor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sensorDaoImpl")
public class SensorDaoImpl implements SensorDao {


    @Override
    public List<Sensor> findAllSensors() {

        Sensor sensor = new Sensor();
        sensor.setSensorName("Sensor 1");
        sensor.setSensorModel("PC33-56");
        sensor.setSensorType("Pressure");
        sensor.setSensorRange("6-17");

        Sensor sensor1 = new Sensor();
        sensor1.setSensorName("Sensor 1");
        sensor1.setSensorModel("PC33-56");
        sensor1.setSensorType("Pressure");
        sensor1.setSensorType("Pressure");
        sensor1.setSensorRange("0-28");

        Sensor sensor2 = new Sensor();
        sensor2.setSensorName("Sensor 1");
        sensor2.setSensorModel("PC33-56");
        sensor2.setSensorType("Pressure");
        sensor2.setSensorType("Pressure");
        sensor2.setSensorRange("-8 to 28");

        return List.of(sensor1,sensor2, sensor);

    }

}