package com.nikola.CarGarage.Services;

import com.nikola.CarGarage.Classes.Car;
import com.nikola.CarGarage.Classes.Garage;
import com.nikola.CarGarage.Classes.Maintenance;
import com.nikola.CarGarage.DTO.CreateMaintenanceDTO;
import com.nikola.CarGarage.DTO.ResponseMaintenanceDTO;
import com.nikola.CarGarage.DTO.UpdateMaintenanceDTO;
import com.nikola.CarGarage.Repositories.CarRepository;
import com.nikola.CarGarage.Repositories.GarageRepository;
import com.nikola.CarGarage.Repositories.MaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;
    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository, CarRepository carRepository, GarageRepository garageRepository) {
        this.maintenanceRepository = maintenanceRepository;
        this.carRepository = carRepository;
        this.garageRepository = garageRepository;
    }

    public Maintenance createMaintenance(CreateMaintenanceDTO createMaintenanceDTO) {

        Optional<Car> optionalCar = carRepository.findById(createMaintenanceDTO.getCarId());
        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Car not found");
        }

        Optional<Garage> optionalGarage = garageRepository.findById(createMaintenanceDTO.getGarageId());
        if (optionalGarage.isEmpty()) {
            throw new RuntimeException("Garage not found");
        }

        Maintenance maintenance = new Maintenance();
        maintenance.setCar(optionalCar.get());
        maintenance.setGarage(optionalGarage.get());
        maintenance.setServiceType(createMaintenanceDTO.getServiceType());
        maintenance.setScheduledDate(createMaintenanceDTO.getScheduledDate());

        return maintenanceRepository.save(maintenance);
    }

    public List<ResponseMaintenanceDTO> findAllMaintenance() {
        List<Maintenance> maintenances = maintenanceRepository.findAll();

        return maintenances.stream().map(this::convertToResponseMaintenanceDTO).collect(Collectors.toList());
    }

    public Maintenance updateMaintenance(int id, UpdateMaintenanceDTO updateMaintenanceDTO) {
        Optional<Maintenance> optionalMaintenance = maintenanceRepository.findById(id);
        if (optionalMaintenance.isEmpty()) {
            throw new RuntimeException("Maintenance not found");
        }

        Optional<Car> optionalCar = carRepository.findById(updateMaintenanceDTO.getCarId());
        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Car not found");
        }

        Optional<Garage> optionalGarage = garageRepository.findById(updateMaintenanceDTO.getGarageId());
        if (optionalGarage.isEmpty()) {
            throw new RuntimeException("Garage not found");
        }

        Maintenance maintenance = optionalMaintenance.get();
        maintenance.setCar(optionalCar.get());
        maintenance.setGarage(optionalGarage.get());
        maintenance.setServiceType(updateMaintenanceDTO.getServiceType());
        maintenance.setScheduledDate(updateMaintenanceDTO.getScheduledDate());

        return maintenanceRepository.save(maintenance);
    }

    public void deleteMaintenance(int id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new RuntimeException("Maintenance not found");
        }
        maintenanceRepository.deleteById(id);
    }

    public ResponseMaintenanceDTO convertToResponseMaintenanceDTO(Maintenance maintenance) {
        return new ResponseMaintenanceDTO(
                maintenance.getId(),
                maintenance.getCar().getId(),
                maintenance.getCarName(),
                maintenance.getServiceType(),
                maintenance.getScheduledDate(),
                maintenance.getGarage().getId(),
                maintenance.getGarage().getName()
        );
    }
}