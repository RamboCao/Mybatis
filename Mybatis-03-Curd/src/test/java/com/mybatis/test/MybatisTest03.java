package com.mybatis.test;

import com.mybatis.bean.Employee;
import com.mybatis.mapper.EmployeeMapper03;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

public class MybatisTest03 {

    public SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper03 mapper = sqlSession.getMapper(EmployeeMapper03.class);
            List<Integer> ids = Collections.singletonList(1);
            Employee employee = mapper.getEmployee(ids);
            System.out.println(employee);
        }
    }

    @Test
    public void selectByIdAndName() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper03 mapper = sqlSession.getMapper(EmployeeMapper03.class);
//            Employee employee = mapper.getEmployeeByIdAndName(new Employee(2 , "Tom"));

//            Employee employee = new Employee(1, "Tom");

            Map<String, Object> params = new HashMap<>();
            params.put("id", 2);
            params.put("lastName", null);
            Employee employee = mapper.getEmployeeByIdAndName(params);
            System.out.println(employee);
        }
    }

    /*
     * 测试增删改
     * 1、mybatis允许增删改直接定义以下类型返回值
     * 		Integer、Long、Boolean、void
     * 2、我们需要手动提交数据
     * 		sqlSessionFactory.openSession();===》手动提交
     * 		sqlSessionFactory.openSession(true);===》自动提交
     */

    @Test
    public void insertTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper03 mapper = sqlSession.getMapper(EmployeeMapper03.class);
            Employee employee = new Employee(null, "NiNa", 1);
            mapper.insertEmployee(employee);
            System.out.println(employee.getId());
            sqlSession.commit();
        }
    }

    @Test
    public void updateTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper03 mapper = sqlSession.getMapper(EmployeeMapper03.class);
            Employee employee = new Employee(1, "Jerry", 0);
            boolean success = mapper.updateEmployee(employee);
            System.out.println(success);
            sqlSession.commit();
        }
    }

    @Test
    public void deleteTest() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            EmployeeMapper03 mapper = sqlSession.getMapper(EmployeeMapper03.class);
            mapper.deleteEmployee(3);
            sqlSession.commit();
        }
    }
}
