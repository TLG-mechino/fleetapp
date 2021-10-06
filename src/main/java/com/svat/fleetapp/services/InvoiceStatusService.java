package com.svat.fleetapp.services;

import com.svat.fleetapp.models.InvoiceStatus;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.repositories.InvoiceStatusRepository;
import com.svat.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    InvoiceStatusRepository invoiceStatusRepository;

    public List<InvoiceStatus> getInvoiceStatus(){
        return invoiceStatusRepository.findAll();
    }

    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }
}
