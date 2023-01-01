package com.example.fullstackdemo.service;

import com.example.fullstackdemo.exception.ResourceNotFoundException;
import com.example.fullstackdemo.model.Employee;
import com.example.fullstackdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee deleteEmployee(long Id) {
        Employee employee = repository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", Id));
        repository.deleteById(Id);
        return employee;
    }

    @Override
    public Employee editEmployee(Employee employee) {
        Employee updatedEmployee = repository.findById(employee.getId()).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employee.getId()));
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setEmailId(employee.getEmailId());
        saveEmployee(updatedEmployee);
        return null;
    }
}
