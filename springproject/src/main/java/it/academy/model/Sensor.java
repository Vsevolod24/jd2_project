package it.academy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.websocket.OnError;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorId;

    @Column
    private String sensorName;

    @Column
    private String sensorModel;

    @Column
    private String rangeFrom;

    @Column
    private String rangeTo;

    @Column
    private String sensorDescription;

    @Column
    private String sensorLocation;

    @ManyToOne
    @JoinColumn(name = "idFromType")
    private Type idFromType;

    @ManyToOne
    @JoinColumn(name = "idFromUnit")
    private Unit idFromUnit;
}
