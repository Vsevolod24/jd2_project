package it.academy.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String model;

    @Column
    private String rangeFrom;

    @Column
    private String rangeTo;

    @Column
    private String description;

    @Column
    private String location;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Unit unit;

    public Sensor(int i) {

    }
}
