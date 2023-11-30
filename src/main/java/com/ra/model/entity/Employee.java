package com.ra.model.entity;

import java.sql.Date;

public class Employee {
    private int id;
    private String name;
    private int phone;
    private String address;
    private Date birthday;
    private boolean sex;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int phone, String address, Date birthday, boolean sex, double salary) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.birthday = birthday;
        this.sex = sex;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
