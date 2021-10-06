package com.svat.fleetapp.repositories;


import com.svat.fleetapp.models.VehicleHire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleHireRepository extends JpaRepository<VehicleHire, Integer> {
}
