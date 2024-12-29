package com.nikola.CarGarage.Controllers;

import com.nikola.CarGarage.Classes.Car;
import com.nikola.CarGarage.DTO.CreateCarDTO;
import com.nikola.CarGarage.DTO.ResponseCarDTO;
import com.nikola.CarGarage.DTO.UpdateCarDTO;
import com.nikola.CarGarage.Services.CarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")

public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<ResponseCarDTO> showAllCars(){
        return carService.findAllCars();
    }

    @PostMapping
    public Car createCar(@RequestBody CreateCarDTO createCarDTO) {
        return carService.createCar(createCarDTO);
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable int id, @RequestBody UpdateCarDTO updateCarDTO) {
        return carService.updateCar(id, updateCarDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        carService.deleteCar(id);
    }
}