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
public class VehicleController {
    @Autowired
    VehicleService vehicleService;
    @Autowired
    LocationService locationService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    VehicleMakeService vehicleMakeService;
    @Autowired
    VehicleStatusService vehicleStatusService;
    @Autowired
    VehicleTypeService vehicleTypeService;
    @Autowired
    VehicleModelService vehicleModelService;

    @GetMapping("/vehicles")
    public String getVehicles(Model model){
        List<Vehicle> vehicleList = vehicleService.getVehicles();
        model.addAttribute("vehicles", vehicleList);

        List<Location> locationList = locationService.getLocations();
        model.addAttribute("locations", locationList);

        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees", employeeList);

        List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
        model.addAttribute("vehicleMakes", vehicleMakeList);

        List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatus();
        model.addAttribute("vehicleStatuss", vehicleStatusList);

        List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleTypes();
        model.addAttribute("vehicleTypes", vehicleTypeList);

        List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
        model.addAttribute("vehicleModels", vehicleModelList);
        return "Vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping("vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id){
        return vehicleService.findById(id);
    }

    @RequestMapping(value = "vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }
}
