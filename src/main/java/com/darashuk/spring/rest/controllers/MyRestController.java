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

        if (employee == null) {
            throw new NoSuchEmployeeExeption("there no employee with "+id+" in DB");
        }
        return employee;
    }

    //метод обработчик исключений  - если нет такого id
    //при срабатывании Exception - оно передается в параметры метода, дальше в объект нами созданного класса,
    // дальше в объект класса ResponseEntity

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handlException(Exception exception){

        EmployeeIncorrectData incorrectData = new EmployeeIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_ACCEPTABLE);

    }


}
