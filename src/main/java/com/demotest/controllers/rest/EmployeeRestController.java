package com.demotest.controllers.rest;


import com.demotest.service.implementations.EmployeeServiceImpl;
import com.demotest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeServiceImpl employeeService;

    @Autowired
    public EmployeeRestController(EmployeeServiceImpl employeeDAO) {
        this.employeeService = employeeDAO;
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody Employee employee) {
//        Employee employee = new Employee("kiko", "mijalkov", "hristijanmijalov2@gmail.com");
        this.employeeService.save(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return this.employeeService.findEmployeeById(employeeId);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        this.employeeService.update(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        this.employeeService.delete(employeeId);
    }

}
