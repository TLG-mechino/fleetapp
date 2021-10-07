package com.svat.fleetapp.services;

import com.svat.fleetapp.models.Employee;
import com.svat.fleetapp.models.Employee;
import com.svat.fleetapp.models.Location;
import com.svat.fleetapp.models.User;
import com.svat.fleetapp.repositories.EmployeeRepository;
import com.svat.fleetapp.repositories.EmployeeRepository;
import com.svat.fleetapp.repositories.LocationRepository;
import com.svat.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String un) {
        return employeeRepository.findByUsername(un);
    }
    
    public void assignUsername(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(
                employee.getFirstname(),
                employee.getLastname()
        );
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }
}
