package com.nikola.CarGarage;

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
    public Car addCar(@RequestBody CreateCarDTO carDTO){
        return carService.addCar(carDTO);
    }
}
