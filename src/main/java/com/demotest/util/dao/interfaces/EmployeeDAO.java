package com.demotest.util.dao.interfaces;

import com.demotest.entity.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;

public interface EmployeeDAO {

    void save(Employee employee);
    Employee getEmployeeById(int id);
    List<Employee> getEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(int id);
}
