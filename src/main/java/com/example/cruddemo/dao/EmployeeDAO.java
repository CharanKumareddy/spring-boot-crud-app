package com.example.cruddemo.dao;


import com.example.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findEmpoyeeById(int id);
    Employee save(Employee Employee);
    void delete(int id);
}
