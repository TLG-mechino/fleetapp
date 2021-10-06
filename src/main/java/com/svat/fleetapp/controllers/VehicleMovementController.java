package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.VehicleMovement;
import com.svat.fleetapp.models.Vehicle;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.services.VehicleMovementService;
import com.svat.fleetapp.services.VehicleService;
import com.svat.fleetapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {
    @Autowired
    VehicleMovementService vehicleMovementService;
    @Autowired
    LocationService locationService;
    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehiclemovements")
    public String getVehicleMovements(Model model){
        List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
        model.addAttribute("vehicleMovements", vehicleMovementList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);
        return "VehicleMovement";
    }

    @PostMapping("/vehiclemovements/addNew")
    public String addNew(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehiclemovements";
    }

    @RequestMapping("vehiclemovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id){
        return vehicleMovementService.findById(id);
    }

    @RequestMapping(value = "vehiclemovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehiclemovements";
    }

    @RequestMapping(value = "vehiclemovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMovementService.delete(id);
        return "redirect:/vehiclemovements";
    }
}
