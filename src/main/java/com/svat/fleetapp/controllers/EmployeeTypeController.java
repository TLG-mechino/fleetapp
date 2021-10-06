package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.EmployeeType;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.EmployeeTypeService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeTypeController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    EmployeeTypeService employeeTypeService;

    @GetMapping("/employeetypes")
    public String getEmployeeTypes(Model model){
//        List<Country> countryList = countryService.getCountries();
//        List<State> stateList = stateService.getStates();
        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();

//        model.addAttribute("countries", countryList);
//        model.addAttribute("states", stateList);
        model.addAttribute("employeeTypes", employeeTypeList);
        return "EmployeeType";
    }

    @PostMapping("/employeetypes/addNew")
    public String addNew(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeetypes";
    }

    @RequestMapping("employeetypes/findById")
    @ResponseBody
    public Optional<EmployeeType> findById(int id){
        return employeeTypeService.findById(id);
    }

    @RequestMapping(value = "employeetypes/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(EmployeeType employeeType){
        employeeTypeService.save(employeeType);
        return "redirect:/employeetypes";
    }

    @RequestMapping(value = "employeetypes/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeTypeService.delete(id);
        return "redirect:/employeetypes";
    }
}
