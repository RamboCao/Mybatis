package com.mybatis.mapper;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper03 {


    Employee getEmployee(Integer id);

    Employee getEmployee(List<Integer> ids);

//    Employee getEmployeeByIdAndName(@Param("id") Integer id, @Param("lastName") String lastName);

//    Employee getEmployeeByIdAndName(Employee employee);

    Employee getEmployeeByIdAndName(Map<String, Object> params);

    void insertEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    void deleteEmployee(Integer id);

}
