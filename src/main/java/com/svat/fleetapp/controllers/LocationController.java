package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {
    @Autowired
    LocationService locationService;
    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;

    @GetMapping("/locations")
    public String getLocations(Model model){
        List<Country> countryList = countryService.getCountries();
        List<State> stateList = stateService.getStates();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("locations", locationList);
        return "Location";
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping("locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id){
        return locationService.findById(id);
    }

    @RequestMapping(value = "locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }
}
