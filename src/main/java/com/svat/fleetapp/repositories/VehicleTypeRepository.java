package com.svat.fleetapp.repositories;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.Vehicle;
import com.svat.fleetapp.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
