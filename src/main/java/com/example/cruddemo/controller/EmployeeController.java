package com.example.cruddemo.controller;

import com.example.cruddemo.dao.EmployeeDAOJpaImpl;
import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id){
        Employee theEmployee = employeeService.findEmployeeById(id);
        if(theEmployee == null){
            throw new RuntimeException("Employee is not Found " + theEmployee);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @DeleteMapping("employees/{id}")
    public void delete(@PathVariable int id){
        employeeService.delete(id);
    }


}
