package com.svat.fleetapp.repositories;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Integer> {
}
