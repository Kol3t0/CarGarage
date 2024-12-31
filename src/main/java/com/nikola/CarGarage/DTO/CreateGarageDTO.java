package com.nikola.CarGarage.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CreateGarageDTO {

    @NotEmpty(message = "Name is required")
    private String name;

    @NotEmpty(message = "Location is required")
    private String location;

    @NotEmpty(message = "City is required")
    private String city;

    @NotNull(message = "Capacity is required")
    private int capacity;

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}