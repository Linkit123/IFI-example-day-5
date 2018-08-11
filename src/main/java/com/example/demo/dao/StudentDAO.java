package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by trinhngoclinh on 8/11/2018.
 */
@Transactional
@Repository
public class StudentDAO implements IStudentDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getAllStudent() {
        String sqlfindall="FROM Student as std ORDER BY std.studentId";
        return (List<Student>) entityManager.createQuery(sqlfindall).getResultList();
    }

    @Override
    public Student getStudentById(int studentId) {
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public void addStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        Student std = getStudentById(student.getStudentId());
        std.setStudentName(student.getStudentName());
        std.setStudentAge(student.getStudentAge());
        std.setStudentAddress(student.getStudentAddress());
        entityManager.flush();
    }

    @Override
    public void deleteStudent(int studentId) {
        entityManager.remove(getStudentById(studentId));
    }

    @Override
    public boolean studentExists(String studentName, int studentId) {
        String sqlcheck = "FROM Student as std WHERE std.studentName=? and std.studentId=?";
        int count = entityManager.createQuery(sqlcheck).setParameter(1,studentName).setParameter(2,studentId).getResultList().size();
        return count>0 ? true:false;
    }
}
