package com.nikola.CarGarage.Repositories;

import com.nikola.CarGarage.Classes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
}