package com.jiangjf.studyweb.dao;

import com.jiangjf.studyweb.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    int add(Student student);

    int update(Student student);

    int deleteBySno(String sno);

    List<Map<String, Object>> queryStudentListMap();

    Student queryStudentBySno(String sno);
}
