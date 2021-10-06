package com.svat.fleetapp.repositories;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
