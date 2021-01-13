package com.mybatis.dao;

import com.mybatis.bean.Employee;

public interface EmployeeMapper {

    Employee getEmployee(Integer id);
}
