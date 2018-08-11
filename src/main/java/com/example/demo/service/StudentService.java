package com.example.demo.service;

import com.example.demo.dao.IStudentDAO;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by trinhngoclinh on 8/11/2018.
 */
@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getAllStudent();
    }

    @Override
    public Student getStudentById(int studentId) {
        Student obj = studentDAO.getStudentById(studentId);
        return obj;
    }

    @Override
    public synchronized  boolean addStudent(Student student) {
        if(studentDAO.studentExists(student.getStudentName(),student.getStudentId())){
            return false;
        }else {
            studentDAO.addStudent(student);
            return true;
        }
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}
