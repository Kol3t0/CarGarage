package com.nikola.CarGarage.Classes;

import jakarta.persistence.*;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String serviceType;
    private String carName;
    private int scheduleDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private Garage garage;
}