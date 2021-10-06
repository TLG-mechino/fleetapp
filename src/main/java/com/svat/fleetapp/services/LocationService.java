package com.svat.fleetapp.services;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.repositories.CountryRepository;
import com.svat.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<Location> getLocations(){
        return locationRepository.findAll();
    }

    public void save(Location location){
        locationRepository.save(location);
    }

    public Optional<Location> findById(int id){
        return locationRepository.findById(id);
    }

    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}
