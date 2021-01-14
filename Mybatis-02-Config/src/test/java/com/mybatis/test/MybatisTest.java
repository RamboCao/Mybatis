package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.mapper.EmployeeMapper02;
import com.mybatis.mapper.EmployeeMapperAnnotation;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper02 mapper = sqlSession.getMapper(EmployeeMapper02.class);
            Employee employee = mapper.getEmployee(1);
            System.out.println(employee);
        }
    }

    @Test
    public void test01() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);
            Employee employee = mapper.getEmployeeByAnnotation(1);
            System.out.println(employee);
        }
    }
}
