package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.models.VehicleType;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import com.svat.fleetapp.services.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleTypeController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    VehicleTypeService vehicleTypeService;

    @GetMapping("/vehicletypes")
    public String getVehicleTypes(Model model){
//        List<Country> countryList = countryService.getCountries();
//        List<State> stateList = stateService.getStates();
        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();

//        model.addAttribute("countries", countryList);
//        model.addAttribute("states", stateList);
        model.addAttribute("vehicleTypes", vehicleTypeList);
        return "VehicleType";
    }

    @PostMapping("/vehicletypes/addNew")
    public String addNew(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicletypes";
    }

    @RequestMapping("vehicletypes/findById")
    @ResponseBody
    public Optional<VehicleType> findById(int id){
        return vehicleTypeService.findById(id);
    }

    @RequestMapping(value = "vehicletypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleType vehicleType){
        vehicleTypeService.save(vehicleType);
        return "redirect:/vehicletypes";
    }

    @RequestMapping(value = "vehicletypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleTypeService.delete(id);
        return "redirect:/vehicletypes";
    }
}
