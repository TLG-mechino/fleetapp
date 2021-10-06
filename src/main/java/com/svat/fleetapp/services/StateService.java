package com.svat.fleetapp.services;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.repositories.CountryRepository;
import com.svat.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public List<State> getStates(){
        return stateRepository.findAll();
    }

    public void save(State state){
        stateRepository.save(state);
    }

    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
