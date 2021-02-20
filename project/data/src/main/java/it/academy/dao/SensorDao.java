package it.academy.dao;

import java.util.List;

import it.academy.model.Sensor;

public interface SensorDao {

    List<Sensor> findAllSensors();

}