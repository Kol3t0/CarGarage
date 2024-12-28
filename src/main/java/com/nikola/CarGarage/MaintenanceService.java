package com.nikola.CarGarage;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceService {
    private final MaintenanceRepository maintenanceRepository;

    public MaintenanceService(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    public List<Maintenance> getAllMaintenanceRecords() {
        return maintenanceRepository.findAll();
    }

    public Maintenance getMaintenanceById(int id) {
        return maintenanceRepository.findById(id).orElse(null);
    }

    public void deleteMaintenance(int id) {
        maintenanceRepository.deleteById(id);
    }
}