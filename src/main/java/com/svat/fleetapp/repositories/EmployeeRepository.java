package com.svat.fleetapp.repositories;

import com.svat.fleetapp.models.Client;
import com.svat.fleetapp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByUsername(String un);
}
