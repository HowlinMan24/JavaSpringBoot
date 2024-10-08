package com.demotest.util.dao.implementations;

import com.demotest.util.dao.interfaces.EmployeeDAO;
import com.demotest.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Employee employee) {
        this.entityManager.persist(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public List<Employee> getEmployees() {
        return this.entityManager.createQuery("FROM Employee", Employee.class).getResultList();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee dbEmployee = this.entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteEmployeeById(int id) {
        this.entityManager.remove(getEmployeeById(id));
    }

}
