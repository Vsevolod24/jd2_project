package it.academy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Sensor {

    @Column
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String sensorId;

    @Column
    private String sensorName;

    @Column
    private String sensorModel;

    @Column
    private String sensorType;

    @Column
    private String sensorRange;

    @Column
    private String sensorUnit;

    @Column
    private String sensorLocation;

}