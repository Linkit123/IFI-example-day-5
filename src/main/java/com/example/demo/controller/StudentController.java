package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by trinhngoclinh on 8/11/2018.
 */
@Controller
@RequestMapping("user")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id){
        Student student=studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
//    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> list = studentService.getAllStudent();
        return new ResponseEntity<List<Student>>(list,HttpStatus.OK);
    }
    @PostMapping("student")
    public ResponseEntity<Void> addStudent(@RequestBody Student student, UriComponentsBuilder componentsBuilder){
        boolean flag = studentService.addStudent(student);
        if (flag == false) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(componentsBuilder.path("/article/{id}").buildAndExpand(student.getStudentId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    @PutMapping("student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }
    @DeleteMapping("student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Integer id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
