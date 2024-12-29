package com.nikola.CarGarage.Repositories;

import com.nikola.CarGarage.Classes.Maintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
}