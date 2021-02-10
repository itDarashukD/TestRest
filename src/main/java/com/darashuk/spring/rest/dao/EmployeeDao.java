package com.darashuk.spring.rest.dao;


import com.darashuk.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements IEmployeeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public EmployeeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Employee> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Employee>employeeList = session.createQuery("from Employee",Employee.class).getResultList();

        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class,id);
        return employee;

    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class,id);
        session.delete(employee);

    }
}
