package com.jiangjf.studyweb.mapper;

import com.jiangjf.studyweb.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        student.setSno(resultSet.getString("sno"));
        student.setName(resultSet.getString("sname"));
        student.setSex(resultSet.getString("ssex"));
        return student;
    }
}
