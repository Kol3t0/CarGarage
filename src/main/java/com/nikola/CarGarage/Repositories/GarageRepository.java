package com.nikola.CarGarage.Repositories;

import com.nikola.CarGarage.Classes.Garage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<Garage, Integer> {
}