package com.svat.fleetapp.repositories;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.Vehicle;
import com.svat.fleetapp.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {
}
