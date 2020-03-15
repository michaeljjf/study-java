package com.jiangjf.studyweb.controller;

import com.jiangjf.studyweb.bean.Student;
import com.jiangjf.studyweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/query-student", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return studentService.queryStudentBySno(sno);
    }

    @RequestMapping(value = "/add-student", method = RequestMethod.POST)
    public int add(Student student) {
        return studentService.add(student);
    }
}
