package com.nikola.CarGarage;

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

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    public void deleteCar(int id) {
        carRepository.deleteById(id);
    }

    public List <ResponseCarDTO> findAllCars(){
        List <Car> cars = carRepository.findAll();

        return cars.stream().map(this::convertToResponseCarDTO).collect(Collectors.toList());
    }

    public ResponseCarDTO convertToResponseCarDTO(Car car) {
        List<ResponseGarageDTO> garages = car.getGarage() != null ?
                List.of(new ResponseGarageDTO(
                        car.getGarage().getId(),
                        car.getGarage().getName(),
                        car.getGarage().getAddress(),
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

    public Car addCar(CreateCarDTO createCarDTO){
        Car car = new Car();

        car.setMake(createCarDTO.getMake());
        car.setModel(createCarDTO.getModel());
        car.setLicensePlate(createCarDTO.getLicensePlate());
        car.setProductionYear(createCarDTO.getProductionYear());

        Optional <Garage> optional = garageRepository.findById(createCarDTO.getGarageIds().get(0));

        if (optional.isPresent()){
            car.setGarage(optional.get());
        }
        return carRepository.save(car);
    }
}