package com.jiangjf.studyweb.service;

import com.jiangjf.studyweb.bean.Student;

public interface StudentService {
    int add(Student student);
    int update(Student student);
    int deleteBySno(String sno);
    Student queryStudentBySno(String sno);
}
