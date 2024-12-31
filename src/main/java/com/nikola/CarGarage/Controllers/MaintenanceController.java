package com.nikola.CarGarage.Controllers;

import com.nikola.CarGarage.Classes.Maintenance;
import com.nikola.CarGarage.DTO.CreateMaintenanceDTO;
import com.nikola.CarGarage.DTO.ResponseMaintenanceDTO;
import com.nikola.CarGarage.DTO.UpdateMaintenanceDTO;
import com.nikola.CarGarage.Services.MaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;

    public MaintenanceController(MaintenanceService maintenanceService) {
        this.maintenanceService = maintenanceService;
    }

    @GetMapping
    public List<ResponseMaintenanceDTO> showAllMaintenance() {
        return maintenanceService.findAllMaintenance();
    }

    @PostMapping
    public Maintenance createMaintenance(@RequestBody CreateMaintenanceDTO createMaintenanceDTO) {
        return maintenanceService.createMaintenance(createMaintenanceDTO);
    }

    @PutMapping("/{id}")
    public Maintenance updateMaintenance(@PathVariable int id, @RequestBody UpdateMaintenanceDTO updateMaintenanceDTO) {
        return maintenanceService.updateMaintenance(id, updateMaintenanceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMaintenance(@PathVariable int id) {
        maintenanceService.deleteMaintenance(id);
    }
}