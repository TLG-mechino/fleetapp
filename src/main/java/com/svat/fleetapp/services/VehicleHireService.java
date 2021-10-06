package com.svat.fleetapp.services;

import com.svat.fleetapp.models.VehicleHire;
import com.svat.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {
    @Autowired
    VehicleHireRepository vehicleHireRepository;

    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    }

    public void save(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    public Optional<VehicleHire> findById(int id){
        return vehicleHireRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
