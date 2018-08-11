package com.example.demo.client;

import com.example.demo.controller.StudentController;
import com.example.demo.entity.Student;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by trinhngoclinh on 8/11/2018.
 */
public class RestClientUtil {
    public  void getAllStudentsDemo(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/students";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Student[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Student[].class);
        Student[] students = responseEntity.getBody();
        for(Student student : students) {
            System.out.println("Id:"+student.getStudentId()+", Name:"+student.getStudentName()
                    +", Address: "+student.getStudentAddress()+", Age:"+student.getStudentAge());
        }
    }
    public static void main(String args[]){
        StudentController studentController = new StudentController();
        System.out.println(studentController.getAllStudents());
//        RestClientUtil restClientUtil = new RestClientUtil();
//        restClientUtil.getAllStudentsDemo();
    }
}
