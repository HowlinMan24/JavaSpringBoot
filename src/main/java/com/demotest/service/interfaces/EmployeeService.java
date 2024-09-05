package com.demotest.service.interfaces;

import com.demotest.entity.Employee;

import java.util.List;

public interface EmployeeService {

    void save(Employee employee);

    Employee findEmployeeById(int id);

    List<Employee> findAll();

    Employee update(Employee employee);

    void delete(Integer id);
}
