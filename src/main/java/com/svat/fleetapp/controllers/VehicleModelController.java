package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.models.VehicleModel;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import com.svat.fleetapp.services.VehicleModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleModelController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    VehicleModelService vehicleModelService;

    @GetMapping("/vehiclemodels")
    public String getVehicleModels(Model model){
//        List<Country> countryList = countryService.getCountries();
//        List<State> stateList = stateService.getStates();
        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();

//        model.addAttribute("countries", countryList);
//        model.addAttribute("states", stateList);
        model.addAttribute("vehicleModels", vehicleModelList);
        return "VehicleModel";
    }

    @PostMapping("/vehiclemodels/addNew")
    public String addNew(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehiclemodels";
    }

    @RequestMapping("vehiclemodels/findById")
    @ResponseBody
    public Optional<VehicleModel> findById(int id){
        return vehicleModelService.findById(id);
    }

    @RequestMapping(value = "vehiclemodels/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleModel vehicleModel){
        vehicleModelService.save(vehicleModel);
        return "redirect:/vehiclemodels";
    }

    @RequestMapping(value = "vehiclemodels/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleModelService.delete(id);
        return "redirect:/vehiclemodels";
    }
}
