package com.svat.fleetapp.services;

import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.VehicleStatus;
import com.svat.fleetapp.repositories.LocationRepository;
import com.svat.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {
    @Autowired
    VehicleStatusRepository vehicleStatusRepository;

    public List<VehicleStatus> getVehicleStatus(){
        return vehicleStatusRepository.findAll();
    }

    public void save(VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }
}
