package com.example.fullstackdemo.controller;

import com.example.fullstackdemo.model.Employee;
import com.example.fullstackdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/emp")
@RestController
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @DeleteMapping("{Id}")
    public Employee deleteEmployee(@PathVariable long Id){
        return service.deleteEmployee(Id);
    }

    @PutMapping
    public Employee editEmployee(@RequestBody Employee employee){
        return service.editEmployee(employee);
    }
}
