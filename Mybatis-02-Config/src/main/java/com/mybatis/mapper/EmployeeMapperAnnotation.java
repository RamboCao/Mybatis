package com.mybatis.mapper;

import com.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {

    @Select("select * from mybatis.EMPLOYEE where id = #{id}")
    public Employee getEmployeeByAnnotation(Integer id);

}
