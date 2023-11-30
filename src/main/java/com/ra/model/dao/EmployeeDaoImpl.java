package com.ra.model.dao;


import com.ra.model.entity.Employee;
import com.ra.util.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList=new ArrayList<>();
        Connection connection=null;
        connection= ConnectionDB.openConnection();
        try {
            CallableStatement call= connection.prepareCall("CALL SELECTEMPLOYEE");
            ResultSet rs=call.executeQuery();
            while (rs.next()){
                Employee employee=new Employee();
                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhone(rs.getInt("phone"));
                employee.setAddress(rs.getString("address"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setSex(rs.getBoolean("sex"));
                employee.setSalary(rs.getDouble("salary"));
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return employeeList;
    }

    @Override
    public boolean saveOfUpdate(Employee employee) {
        Connection connection=null;
        connection=ConnectionDB.openConnection();
        int s1;
        try {
        if (employee.getId()==0){

                CallableStatement call= connection.prepareCall("CALL CREATE_EMPLOYEE(?,?,?,?,?,?)");
              call.setString(1,employee.getName());
              call.setInt(2,employee.getPhone());
              call.setString(3,employee.getAddress());
              call.setDate(4,employee.getBirthday());
              call.setBoolean(5,employee.isSex());
              call.setDouble(6,employee.getSalary());
                s1= call.executeUpdate();
        }else {
                CallableStatement call= connection.prepareCall("{CALL UPDATE_EMPLOYEE(?,?,?,?,?,?,?)}");
            call.setInt(1,employee.getId());
                call.setString(2,employee.getName());
                call.setInt(3,employee.getPhone());
                call.setString(4,employee.getAddress());
                call.setDate(5,employee.getBirthday());
                call.setBoolean(6,employee.isSex());
                call.setDouble(7,employee.getSalary());

                s1=call.executeUpdate();

        }
        if (s1>0){
            return true;
        }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Employee findById(Integer integer) {
        Connection connection=null;
        connection=ConnectionDB.openConnection();
        Employee employee=new Employee();
        try {
        PreparedStatement cs= connection.prepareCall("CALL find_by_id(?)");
        cs.setInt(1,integer);
        ResultSet rs=cs.executeQuery();
            while (rs.next()){

                employee.setId(rs.getInt("id"));
                employee.setName(rs.getString("name"));
                employee.setPhone(rs.getInt("phone"));
                employee.setAddress(rs.getString("address"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setSex(rs.getBoolean("sex"));
                employee.setSalary(rs.getDouble("salary"));
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
        return employee;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection=null;
        connection=ConnectionDB.openConnection();
        try {
            CallableStatement cs=connection.prepareCall("CALL DELETE_EMPLOYEE(?)");
           cs.setInt(1,integer);

            int check= cs.executeUpdate();
            if (check>0){
                System.out.println(integer);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeConnection(connection);
        }
    }
}
