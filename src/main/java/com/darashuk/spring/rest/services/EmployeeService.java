package com.darashuk.spring.rest.services;


import com.darashuk.spring.rest.dao.IEmployeeDao;
import com.darashuk.spring.rest.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    private IEmployeeDao IEmployeeDao;

    @Autowired
    public EmployeeService(IEmployeeDao IEmployeeDao) {
        this.IEmployeeDao = IEmployeeDao;
    }

    @Transactional
    @Override
    public List<Employee> getAll() {
       return IEmployeeDao.getAll();
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        IEmployeeDao.save(employee);
    }

    @Transactional
    @Override
    public Employee getById(int id) {
        return IEmployeeDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        IEmployeeDao.delete(id);

    }
}
