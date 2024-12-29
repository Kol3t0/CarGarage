package com.nikola.CarGarage.Classes;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private String location;
    private String city;
    private int capacity;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars;

    @OneToMany(mappedBy = "garage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Maintenance> maintenanceRecords;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Maintenance> getMaintenanceRecords() {
        return maintenanceRecords;
    }

    public void setMaintenanceRecords(List<Maintenance> maintenanceRecords) {
        this.maintenanceRecords = maintenanceRecords;
    }

    public Garage(int id, String name, String location, String city, int capacity, List<Car> cars, List<Maintenance> maintenanceRecords) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.city = city;
        this.capacity = capacity;
        this.cars = cars;
        this.maintenanceRecords = maintenanceRecords;
    }

    public Garage() {
    }
}