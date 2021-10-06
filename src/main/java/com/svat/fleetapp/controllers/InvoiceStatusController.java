package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.InvoiceStatus;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.InvoiceStatusService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoicestatus")
    public String getLocations(Model model){
//        List<Country> countryList = countryService.getCountries();
        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
//        List<Location> locationList = locationService.getLocations();

//        model.addAttribute("countries", countryList);
        model.addAttribute("invoiceStatus", invoiceStatusList);
//        model.addAttribute("locations", locationList);
        return "InvoiceStatus";
    }

    @PostMapping("/invoicestatus/addNew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoicestatus";
    }

    @RequestMapping("invoicestatus/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusService.findById(id);
    }

    @RequestMapping(value = "invoicestatus/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoicestatus";
    }

    @RequestMapping(value = "invoicestatus/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoicestatus";
    }
}
