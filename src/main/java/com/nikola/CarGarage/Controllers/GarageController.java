package com.nikola.CarGarage.Controllers;

import com.nikola.CarGarage.DTO.CreateGarageDTO;
import com.nikola.CarGarage.DTO.ResponseGarageDTO;
import com.nikola.CarGarage.DTO.UpdateGarageDTO;
import com.nikola.CarGarage.Classes.Garage;
import com.nikola.CarGarage.Services.GarageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/garages")

public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping
    public List<ResponseGarageDTO> showAllGarages() {
        return garageService.findAllGarages();
    }

    @PostMapping
    public ResponseEntity<Garage> createGarage(@Valid @RequestBody CreateGarageDTO createGarageDTO) {
        Garage createdGarage = garageService.createGarage(createGarageDTO);
        return ResponseEntity.ok(createdGarage);
    }

    @PutMapping("/{id}")
    public Garage updateGarage(@PathVariable int id, @RequestBody UpdateGarageDTO updateGarageDTO) {
        return garageService.updateGarage(id, updateGarageDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteGarage(@PathVariable int id) {
        garageService.deleteGarage(id);
    }
}