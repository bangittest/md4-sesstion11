package com.ra.model.service;

import com.ra.model.dao.EmployeeDao;
import com.ra.model.dao.EmployeeDaoImpl;
import com.ra.model.entity.Employee;

import java.util.List;

public class EmployServiceImpl implements EmployeeService {
    EmployeeDao employeeDao=new EmployeeDaoImpl();
    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public boolean saveOfUpdate(Employee employee) {
        return employeeDao.saveOfUpdate(employee);
    }

    @Override
    public Employee findById(Integer integer) {
        return employeeDao.findById(integer);
    }

    @Override
    public void delete(Integer integer) {
    employeeDao.delete(integer);
    }
}
