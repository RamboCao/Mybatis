package com.mybatis.bean;

import org.apache.ibatis.type.Alias;

//@Alias("emp")
public class Employee {
    private Integer id;

    private String lastName;

    private Integer gender;

    public Employee(Integer id, String lastName, Integer gender) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
    }

    public Employee(Integer id, String lastName) {
        this.id = id;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
