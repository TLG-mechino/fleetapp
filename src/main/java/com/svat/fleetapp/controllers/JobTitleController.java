package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.JobTitle;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.State;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.JobTitleService;
import com.svat.fleetapp.services.LocationService;
import com.svat.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JobTitleController {
//    @Autowired
//    LocationService locationService;
//    @Autowired
//    CountryService countryService;
    @Autowired
    JobTitleService jobTitleService;

    @GetMapping("/jobtitles")
    public String getJobTitles(Model model){
//        List<Country> countryList = countryService.getCountries();
//        List<State> stateList = stateService.getStates();
        List<JobTitle> jobTitleList = jobTitleService.getJobTitles();

//        model.addAttribute("countries", countryList);
//        model.addAttribute("states", stateList);
        model.addAttribute("jobTitles", jobTitleList);
        return "JobTitle";
    }

    @PostMapping("/jobtitles/addNew")
    public String addNew(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobtitles";
    }

    @RequestMapping("jobtitles/findById")
    @ResponseBody
    public Optional<JobTitle> findById(int id){
        return jobTitleService.findById(id);
    }

    @RequestMapping(value = "jobtitles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(JobTitle jobTitle){
        jobTitleService.save(jobTitle);
        return "redirect:/jobtitles";
    }

    @RequestMapping(value = "jobtitles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        jobTitleService.delete(id);
        return "redirect:/jobtitles";
    }
}
