package com.nikola.CarGarage.DTO;

import java.time.LocalDate;

public class CreateMaintenanceDTO {

    private int garageId;

    private int carId;

    private String serviceType;

    private LocalDate scheduledDate;

    public int getGarageId() {
        return garageId;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String scheduledDate) {
        this.scheduledDate = LocalDate.parse(scheduledDate);
    }
}