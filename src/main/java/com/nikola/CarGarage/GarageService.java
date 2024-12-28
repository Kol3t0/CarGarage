package com.nikola.CarGarage;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GarageService {
    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(Garage garage) {
        return garageRepository.save(garage);
    }

    public List<Garage> getAllGarages() {
        return garageRepository.findAll();
    }

    public Garage getGarageById(int id) {
        return garageRepository.findById(id).orElse(null);
    }

    public void deleteGarage(int id) {
        garageRepository.deleteById(id);
    }

    public List <ResponseGarageDTO> findAllGarages(){
        List <Garage> garages = garageRepository.findAll();

        return garages.stream().map(this::convertToResponseGarageDTO).collect(Collectors.toList());
    }

    public ResponseGarageDTO convertToResponseGarageDTO(Garage garage) {
        return new ResponseGarageDTO(
                garage.getId(),
                garage.getName(),
                garage.getAddress(),
                garage.getCity(),
                garage.getCapacity()
        );
    }
}