package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by trinhngoclinh on 8/10/2018.
 */
@Entity
@Table(name="student")
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="student_id")
    private int studentId;

    @Column(name="student_name")
    private String studentName;

    @Column(name="student_address")
    private String studentAddress;

    @Column(name="student_age")
    private int studentAge;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }
}
