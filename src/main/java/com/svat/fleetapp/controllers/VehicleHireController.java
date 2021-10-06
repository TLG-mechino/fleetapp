package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.Vehicle;
import com.svat.fleetapp.models.VehicleHire;
import com.svat.fleetapp.services.ClientService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.VehicleHireService;
import com.svat.fleetapp.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {
    @Autowired
    VehicleHireService vehicleHireService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    LocationService locationService;
    @Autowired
    ClientService clientService;

    @GetMapping("/vehiclehires")
    public String getVehicleHires(Model model){

        List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
        model.addAttribute("vehicleHires", vehicleHireList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);
        return "VehicleHire";
    }

    @PostMapping("/vehiclehires/addNew")
    public String addNew(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehires";
    }

    @RequestMapping("vehiclehires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id){
        return vehicleHireService.findById(id);
    }

    @RequestMapping(value = "vehiclehires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehiclehires";
    }

    @RequestMapping(value = "vehiclehires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleHireService.delete(id);
        return "redirect:/vehiclehires";
    }
}
