package com.nikola.CarGarage.DTO;

import java.time.LocalDate;

public class ResponseMaintenanceDTO {
    private int id;
    private int carId;
    private String carName;
    private String serviceType;
    private LocalDate scheduledDate;
    private int garageId;
    private String garageName;

    public ResponseMaintenanceDTO(int id, int carId, String carName, String serviceType, LocalDate scheduledDate, int garageId, String garageName) {
        this.id = id;
        this.carId = carId;
        this.carName = carName;
        this.serviceType = serviceType;
        this.scheduledDate = scheduledDate;
        this.garageId = garageId;
        this.garageName = garageName;
    }

    public int getId() {
        return id;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarName() {
        return carName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public LocalDate getScheduledDate() {
        return scheduledDate;
    }

    public int getGarageId() {
        return garageId;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setScheduledDate(LocalDate scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public void setGarageId(int garageId) {
        this.garageId = garageId;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }
}