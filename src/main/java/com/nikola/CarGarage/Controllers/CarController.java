package com.nikola.CarGarage.Controllers;

import com.nikola.CarGarage.Classes.Car;
import com.nikola.CarGarage.DTO.CreateCarDTO;
import com.nikola.CarGarage.DTO.ResponseCarDTO;
import com.nikola.CarGarage.DTO.UpdateCarDTO;
import com.nikola.CarGarage.Services.CarService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<ResponseCarDTO> showAllCars(){
        return carService.findAllCars();
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@Valid @RequestBody CreateCarDTO createCarDTO) {
        Car createdCar = carService.createCar(createCarDTO);
        return ResponseEntity.ok(createdCar);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable int id, @Valid @RequestBody UpdateCarDTO updateCarDTO) {
        return carService.updateCar(id, updateCarDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }
}