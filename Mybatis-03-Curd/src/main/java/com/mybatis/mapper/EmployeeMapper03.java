package com.mybatis.mapper;

import com.mybatis.bean.Employee;

public interface EmployeeMapper03 {


    Employee getEmployee(Integer id);

    void insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

}
