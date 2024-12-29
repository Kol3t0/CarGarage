package com.nikola.CarGarage.Services;

import com.nikola.CarGarage.DTO.CreateGarageDTO;
import com.nikola.CarGarage.DTO.ResponseGarageDTO;
import com.nikola.CarGarage.DTO.UpdateGarageDTO;
import com.nikola.CarGarage.Classes.Garage;
import com.nikola.CarGarage.Repositories.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GarageService {
    private final GarageRepository garageRepository;

    public GarageService(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    public Garage createGarage(CreateGarageDTO createGarageDTO) {
        Garage garage = new Garage();

        garage.setName(createGarageDTO.getName());
        garage.setAddress(createGarageDTO.getLocation());
        garage.setCity(createGarageDTO.getCity());
        garage.setCapacity(createGarageDTO.getCapacity());

        return garageRepository.save(garage);
    }

    public List<ResponseGarageDTO> findAllGarages() {
        List<Garage> garages = garageRepository.findAll();

        return garages.stream().map(this::convertToResponseGarageDTO).collect(Collectors.toList());
    }

    public Garage updateGarage(int id, UpdateGarageDTO updateGarageDTO) {
        Optional<Garage> optionalGarage = garageRepository.findById(id);
        if (optionalGarage.isEmpty()) {
            throw new RuntimeException("Garage not found");
        }

        Garage garage = optionalGarage.get();
        garage.setName(updateGarageDTO.getName());
        garage.setAddress(updateGarageDTO.getLocation());
        garage.setCity(updateGarageDTO.getCity());
        garage.setCapacity(updateGarageDTO.getCapacity());

        return garageRepository.save(garage);
    }


    public Garage getGarageById(int id) {
        return garageRepository.findById(id).orElse(null);
    }

    public void deleteGarage(int id) {
        if (!garageRepository.existsById(id)) {
            throw new RuntimeException("Garage not found");
        }
        garageRepository.deleteById(id);
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
