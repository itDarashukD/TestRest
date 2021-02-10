package com.darashuk.spring.rest.controllers;


import com.darashuk.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.darashuk.spring.rest.services.IEmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private IEmployeeService employeeService;

    @Autowired
    public MyRestController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> employeeList = employeeService.getAll();
        return employeeList;
    }

    @GetMapping("employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee = employeeService.getById(id);

        return employee;
    }


}
