package com.darashuk.spring.rest.services;



import com.darashuk.spring.rest.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    public List<Employee>getAll();
    public void save(Employee employee);
    Employee getById(int id);
    void delete(int id);

}
