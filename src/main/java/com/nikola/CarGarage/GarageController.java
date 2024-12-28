package com.nikola.CarGarage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/garages")

public class GarageController {
    private GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @GetMapping
    public List<ResponseGarageDTO> showAllGarages(){
        return garageService.findAllGarages();
    }
}
