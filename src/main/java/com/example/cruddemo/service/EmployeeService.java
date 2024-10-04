package com.example.cruddemo.service;


import com.example.cruddemo.dao.EmployeeDAOJpaImpl;
import com.example.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDAOJpaImpl employeeDAOJpa;

    public List<Employee> findAll(){
        return employeeDAOJpa.findAll();
    }

    public Employee findEmployeeById(int id){
        return employeeDAOJpa.findEmpoyeeById(id);
    }
    @Transactional
    public Employee save(Employee employee){
        return employeeDAOJpa.save(employee);
    }

    @Transactional
    public void delete(int id){
        employeeDAOJpa.delete(id);
    }
}
