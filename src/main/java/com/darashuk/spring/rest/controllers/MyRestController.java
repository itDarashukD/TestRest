package com.darashuk.spring.rest.controllers;


import com.darashuk.spring.rest.entity.Employee;
import com.darashuk.spring.rest.exeption_handler.EmployeeIncorrectData;
import com.darashuk.spring.rest.exeption_handler.NoSuchEmployeeExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

        if (employee == null) {// а он равен нулл когда такого значения нет в БД
            throw new NoSuchEmployeeExeption("there no employee with "+id+" in DB");
        }
        return employee;
    }

    @PostMapping("employees")
    public Employee   addNewEmployee(@RequestBody Employee employee){

        employeeService.save(employee);
        return employeeService.getById(employee.getId());
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        employeeService.save(employee);

        return employeeService.getById(employee.getId());
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.getById(id);
        if (employee == null) {
            throw  new NoSuchEmployeeExeption("employee with this  "+ id + " not exist");
        }

        employeeService.delete(id);
        return "employee "+ id +"was deleted";
    }


}
