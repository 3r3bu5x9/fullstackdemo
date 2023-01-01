package com.example.fullstackdemo.service;

import com.example.fullstackdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee deleteEmployee(long Id);
    Employee editEmployee(Employee employee);
}
