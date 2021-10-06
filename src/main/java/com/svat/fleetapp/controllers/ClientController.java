package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.ClientService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    ClientService clientService;
    @Autowired
    StateService stateService;
    @Autowired
    CountryService countryService;

    @GetMapping("/clients")
    public String getClients(Model model){
        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "Client";
    }

    @PostMapping("/clients/addNew")
    public String addNew(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping("clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id){
        return clientService.findById(id);
    }

    @RequestMapping(value = "clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping(value = "clients/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        clientService.delete(id);
        return "redirect:/clients";
    }
}
