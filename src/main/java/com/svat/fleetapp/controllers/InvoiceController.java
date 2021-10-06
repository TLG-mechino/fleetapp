package com.svat.fleetapp.controllers;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.Country;
import com.svat.fleetapp.models.Invoice;
import com.svat.fleetapp.models.InvoiceStatus;
import com.svat.fleetapp.services.ClientService;
import com.svat.fleetapp.services.CountryService;
import com.svat.fleetapp.services.InvoiceService;
import com.svat.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceService InvoiceService;
    @Autowired
    InvoiceStatusService invoiceStatusService;
    @Autowired
    ClientService clientService;

    @GetMapping("/invoices")
    public String getInvoices(Model model){
        List<Invoice> InvoiceList = InvoiceService.getInvoices();
        model.addAttribute("invoices", InvoiceList);

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatus();
        model.addAttribute("invoiceStatuses", invoiceStatusList);

        List<Client> clientList = clientService.getClients();
        model.addAttribute("clients", clientList);
        return "Invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice){
        InvoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping("invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id){
        return InvoiceService.findById(id);
    }

    @RequestMapping(value = "invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice){
        InvoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "invoices/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        InvoiceService.delete(id);
        return "redirect:/invoices";
    }
}
