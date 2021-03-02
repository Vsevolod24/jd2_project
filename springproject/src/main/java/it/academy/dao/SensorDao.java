package it.academy.dao;

import it.academy.model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDao extends JpaRepository<Sensor, Long> {

}
