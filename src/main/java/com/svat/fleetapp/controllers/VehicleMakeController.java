package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.models.VehicleMake;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import com.svat.fleetapp.services.VehicleMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMakeController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    VehicleMakeService vehicleMakeService;

    @GetMapping("/vehiclemakes")
    public String getVehicleMakes(Model model){
//        List<Country> countryList = countryService.getCountries();
//        List<State> stateList = stateService.getStates();
        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();

//        model.addAttribute("countries", countryList);
//        model.addAttribute("states", stateList);
        model.addAttribute("vehicleMakes", vehicleMakeList);
        return "VehicleMake";
    }

    @PostMapping("/vehiclemakes/addNew")
    public String addNew(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehiclemakes";
    }

    @RequestMapping("vehiclemakes/findById")
    @ResponseBody
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeService.findById(id);
    }

    @RequestMapping(value = "vehiclemakes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMake vehicleMake){
        vehicleMakeService.save(vehicleMake);
        return "redirect:/vehiclemakes";
    }

    @RequestMapping(value = "vehiclemakes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMakeService.delete(id);
        return "redirect:/vehiclemakes";
    }
}
