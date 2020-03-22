package com.jiangjf.studyweb.controller;

import com.jiangjf.studyweb.annotation.Log;
import com.jiangjf.studyweb.bean.Student;
import com.jiangjf.studyweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Log("查询某个学生")
    @RequestMapping(value = "/query-student", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return studentService.queryStudentBySno(sno);
    }

    @Log("添加学生")
    @RequestMapping(value = "/add-student", method = RequestMethod.POST)
    public int add(Student student) {
        return studentService.add(student);
    }

    @Log("查询所有学生")
    @RequestMapping(value = "/query-student-list", method = RequestMethod.GET)
    public List<Map<String, Object>> queryStudentList() {
        return studentService.queryStudentListMap();
    }

    @Log("删除某个学生")
    @RequestMapping(value = "/delete-student", method = RequestMethod.GET)
    public int deleteStudent(String sno) {
        return studentService.deleteBySno(sno);
    }
}
