package com.nikola.CarGarage.Repositories;

import com.nikola.CarGarage.Classes.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE (:make IS NULL OR c.make = :make) " +
            "AND (:garageName IS NULL OR c.garage.name = :garageName) " +
            "AND (:yearFrom IS NULL OR c.productionYear >= :yearFrom) " +
            "AND (:yearTo IS NULL OR c.productionYear <= :yearTo)")
    List<Car> findByMakeAndGarageAndProductionYearRange(
            @Param("make") String make,
            @Param("garageName") String garageName,
            @Param("yearFrom") Integer yearFrom,
            @Param("yearTo") Integer yearTo);

}