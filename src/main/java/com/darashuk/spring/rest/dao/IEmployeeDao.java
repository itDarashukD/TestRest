package com.darashuk.spring.rest.dao;

import com.darashuk.spring.rest.entity.Employee;

import java.util.List;

public interface IEmployeeDao {
    public List<Employee> getAll();
    public void save(Employee employee);
    Employee getById(int id);
    void delete(int id);

}
