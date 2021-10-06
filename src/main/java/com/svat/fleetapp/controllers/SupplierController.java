package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Supplier;
import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.SupplierService;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {
    @Autowired
    SupplierService supplierService;
    @Autowired
    StateService stateService;
    @Autowired
    CountryService countryService;

    @GetMapping("/suppliers")
    public String getSuppliers(Model model){
        List<Supplier> supplierList = supplierService.getSuppliers();
        model.addAttribute("suppliers", supplierList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "Supplier";
    }

    @PostMapping("/suppliers/addNew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id){
        return supplierService.findById(id);
    }

    @RequestMapping(value = "suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping(value = "suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
