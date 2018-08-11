package com.example.demo.service;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * Created by trinhngoclinh on 8/11/2018.
 */
public interface IStudentService {
    List<Student> getAllStudent();
    Student getStudentById(int studentId);
    boolean addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
}
