package com.nikola.CarGarage.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class CreateCarDTO {

    @NotEmpty(message = "Make is required")
    private String make;

    @NotEmpty(message = "Model is required")
    private String model;

    @NotNull(message = "Production year is required")
    private int productionYear;

    @NotEmpty(message = "License plate is required")
    @Size(max = 10, message = "License plate cannot be longer than 10 characters")
    private String licensePlate;

    @NotEmpty(message = "At least one garage ID is required")
    private List<Integer> garageIds;;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public List<Integer> getGarageIds() {
        return garageIds;
    }

    public void setGarageIds(List<Integer> garageIds) {
        this.garageIds = garageIds;
    }
}