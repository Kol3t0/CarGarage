package com.nikola.CarGarage.Services;

import com.nikola.CarGarage.Classes.Car;
import com.nikola.CarGarage.Repositories.CarRepository;
import com.nikola.CarGarage.DTO.CreateCarDTO;
import com.nikola.CarGarage.DTO.ResponseCarDTO;
import com.nikola.CarGarage.DTO.ResponseGarageDTO;
import com.nikola.CarGarage.DTO.UpdateCarDTO;
import com.nikola.CarGarage.Classes.Garage;
import com.nikola.CarGarage.Repositories.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final GarageRepository garageRepository;

    public CarService(CarRepository carRepository, GarageRepository garageRepository) {
        this.carRepository = carRepository;
        this.garageRepository = garageRepository;
    }

    public Car createCar(CreateCarDTO createCarDTO) {
        Car car = new Car();

        car.setMake(createCarDTO.getMake());
        car.setModel(createCarDTO.getModel());
        car.setLicensePlate(createCarDTO.getLicensePlate());
        car.setProductionYear(createCarDTO.getProductionYear());

        if (!createCarDTO.getGarageIds().isEmpty()) {
            int garageId = createCarDTO.getGarageIds().get(0);
            Optional<Garage> garageOptional = garageRepository.findById(garageId);
            garageOptional.ifPresent(car::setGarage);
        }

        return carRepository.save(car);
    }

    public List<ResponseCarDTO> findAllCars() {
        List<Car> cars = carRepository.findAll();

        return cars.stream().map(this::convertToResponseCarDTO).collect(Collectors.toList());
    }

    public Car updateCar(int id, UpdateCarDTO updateCarDTO) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isEmpty()) {
            throw new RuntimeException("Car not found");
        }
        Car car = optionalCar.get();

        car.setMake(updateCarDTO.getMake());
        car.setModel(updateCarDTO.getModel());
        car.setLicensePlate(updateCarDTO.getLicensePlate());
        car.setProductionYear(updateCarDTO.getProductionYear());

        if (!updateCarDTO.getGarageIds().isEmpty()) {
            Optional<Garage> optionalGarage = garageRepository.findById(updateCarDTO.getGarageIds().get(0));
            optionalGarage.ifPresent(car::setGarage);
        }

        return carRepository.save(car);
    }

    public void deleteCar(int id) {
        if (!carRepository.existsById(id)) {
            throw new RuntimeException("Car with ID " + id + " not found");
        }
        carRepository.deleteById(id);
    }

    public ResponseCarDTO convertToResponseCarDTO(Car car) {
        List<ResponseGarageDTO> garages = car.getGarage() != null ?
                List.of(new ResponseGarageDTO(
                        car.getGarage().getId(),
                        car.getGarage().getName(),
                        car.getGarage().getLocation(),
                        car.getGarage().getCity(),
                        car.getGarage().getCapacity()
                )) : List.of();

        return new ResponseCarDTO(
                car.getId(),
                car.getMake(),
                car.getModel(),
                car.getProductionYear(),
                car.getLicensePlate(),
                garages
        );
    }
}