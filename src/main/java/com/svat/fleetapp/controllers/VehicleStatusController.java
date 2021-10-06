package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.models.VehicleStatus;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import com.svat.fleetapp.services.VehicleStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleStatusController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    VehicleStatusService vehicleStatusService;

    @GetMapping("/vehiclestatus")
    public String getVehicleStatus(Model model){
//        List<Country> countryList = countryService.getCountries();
//        List<State> stateList = stateService.getStates();
        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();

//        model.addAttribute("countries", countryList);
//        model.addAttribute("states", stateList);
        model.addAttribute("vehicleStatus", vehicleStatusList);
        return "VehicleStatus";
    }

    @PostMapping("/vehiclestatus/addNew")
    public String addNew(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehiclestatus";
    }

    @RequestMapping("vehiclestatus/findById")
    @ResponseBody
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusService.findById(id);
    }

    @RequestMapping(value = "vehiclestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleStatus vehicleStatus){
        vehicleStatusService.save(vehicleStatus);
        return "redirect:/vehiclestatus";
    }

    @RequestMapping(value = "vehiclestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleStatusService.delete(id);
        return "redirect:/vehiclestatus";
    }
}
