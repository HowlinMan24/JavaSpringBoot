package com.demotest.service.implementations;

import com.demotest.entity.Employee;
import com.demotest.service.interfaces.EmployeeService;
import com.demotest.util.dao.implementations.EmployeeDAOImpl;
import com.demotest.util.exceptions.EmployeeNotFoundException;
import com.demotest.util.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository entityManager) {
        this.employeeRepository = entityManager;
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findEmployeeById(int id) {
//        Optional<Employee> employee = this.employeeRepository.findById(id);
//        if (employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new EmployeeNotFoundException("The employee with id " + id + " not found");
//        }
        return this.employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("The employee with id " + id + " not found"));
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee update(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        this.employeeRepository.delete(findEmployeeById(id));
    }
}
