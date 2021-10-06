package com.svat.fleetapp.services;

import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.VehicleMake;
import com.svat.fleetapp.repositories.LocationRepository;
import com.svat.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {
    @Autowired
    VehicleMakeRepository vehicleMakeRepository;

    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    }

    public void save(VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }
}
