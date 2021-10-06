package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Contact;
import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.ContactService;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    ContactService contactService;
    @Autowired
    StateService stateService;
    @Autowired
    CountryService countryService;

    @GetMapping("/contacts")
    public String getContacts(Model model){
        List<Contact> contactList = contactService.getContacts();
        model.addAttribute("contacts", contactList);

        List<State> stateList = stateService.getStates();
        model.addAttribute("states", stateList);

        List<Country> countryList = countryService.getCountries();
        model.addAttribute("countries", countryList);
        return "Contact";
    }

    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping("contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id){
        return contactService.findById(id);
    }

    @RequestMapping(value = "contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }
}
