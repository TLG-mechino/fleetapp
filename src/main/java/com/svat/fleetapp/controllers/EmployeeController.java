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
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    JobTitleService jobTitleService;
    @Autowired
    EmployeeTypeService employeeTypeService;
    @Autowired
    CountryService countryService;
    @Autowired
    StateService stateService;

    @GetMapping("/employees")
    public String getEmployees(Model model){
        List<Employee> employeeList = employeeService.getEmployees();
        model.addAttribute("employees", employeeList);

        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
        model.addAttribute("jobTitles", jobTitleList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);

        List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
        model.addAttribute("employeeTypes", employeeTypeList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);
        return "Employee";
    }

    @PostMapping("/employees/addNew")
    public String addNew(Employee Employee){
        employeeService.save(Employee);
        return "redirect:/employees";
    }

    @RequestMapping("employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id){
        return employeeService.findById(id);
    }

    @RequestMapping(value = "employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
