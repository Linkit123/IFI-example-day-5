package com.example.demo.dao;

import com.example.demo.entity.Student;

import java.util.List;

/**
 * Created by trinhngoclinh on 8/10/2018.
 */
public interface IStudentDAO {
    List<Student> getAllStudent();
    Student getStudentById(int studentId);
    void addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
    boolean studentExists(String studentName,int studentId);
}
