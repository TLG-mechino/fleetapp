package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.*;
import com.svat.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {
    @Autowired
    VehicleMaintenanceService vehicleMaintenanceService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    SupplierService supplierService;

    @GetMapping("/vehicleMaintenances")
    public String getVehicleMaintenances(Model model){
        List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
        model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);

        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", supplierList);
        return "VehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping("vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenanceService.findById(id);
    }

    @RequestMapping(value = "vehicleMaintenances/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping(value = "vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMaintenanceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }
}
