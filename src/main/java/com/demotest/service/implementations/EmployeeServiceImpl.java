package com.demotest.service.implementations;

import com.demotest.entity.Employee;
import com.demotest.service.interfaces.EmployeeService;
import com.demotest.util.dao.implementations.EmployeeDAOImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAOImpl employeeDAO;

    public EmployeeServiceImpl(EmployeeDAOImpl entityManager) {
        this.employeeDAO = entityManager;
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        this.employeeDAO.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
        return this.employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.getEmployees();
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return this.employeeDAO.updateEmployee(employee);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        this.employeeDAO.deleteEmployeeById(findEmployeeById(id).getId());
    }
}
