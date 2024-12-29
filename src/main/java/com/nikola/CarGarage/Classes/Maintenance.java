package com.nikola.CarGarage.Classes;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Maintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serviceType;
    private String carName;
    private LocalDate scheduledDate; // Changed from int to LocalDate

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "garage_id", nullable = false)
    private Garage garage;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Maintenance(int id, String serviceType, String carName, LocalDate scheduledDate, Car car, Garage garage) {
        this.id = id;
        this.serviceType = serviceType;
        this.carName = carName;
        this.scheduledDate = scheduledDate;
        this.car = car;
        this.garage = garage;
    }

    public Maintenance() {
    }
}
