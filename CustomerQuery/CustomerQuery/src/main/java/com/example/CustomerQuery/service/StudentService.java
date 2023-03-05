package com.example.CustomerQuery.service;

import com.example.CustomerQuery.dao.IStudentRepository;
import com.example.CustomerQuery.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    IStudentRepository studentRepository;
    public Student saveStudent(Student student) {
        Student student1=studentRepository.save(student);
        return student1;
    }

    //fetching by first name
    public JSONArray findStudentByfirstName(String firstName) {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            if(student.getFirstName().equals(firstName)){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
            }
        }
        return studentList;
    }
    public JSONArray findStudentsByfirstNameQuery(String firstName) {
        List<Student> students=studentRepository.findStudentByfirstName(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    //fetching by last name
    public JSONArray findStudentBylastName(String lastName) {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            if(student.getLastName().equals(lastName)){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
            }
        }
        return studentList;
    }
    public JSONArray findStudentsBylastNameQuery(String lastName) {
        List<Student> students=studentRepository.findStudentBylastName(lastName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    //fetching by age
    public JSONArray findStudentByAge(Integer age) {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            if(student.getAge()==age){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
            }
        }
        return studentList;
    }
    public JSONArray findStudentsByAgeQuery(Integer age) {
        List<Student> students=studentRepository.findStudentByAge(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    //fetching by active
    public JSONArray findStudentByActive(Boolean active) {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            if(student.getActive()==active){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
            }
        }
        return studentList;
    }
    public JSONArray findStudentsByActiveQuery(Boolean active) {
        List<Student> students=studentRepository.findStudentByActive(active);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    //fetching by date
    public JSONArray findStudentByDate(Date date) {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            if(student.getAdmissionDate()==date){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
            }
        }
        return studentList;
    }
    public JSONArray findStudentsByDateQuery(Date date) {
        List<Student> students=studentRepository.findStudentByDate(date);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    //fetching by age
    public JSONArray findStudentById(Integer id) {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            if(student.getStudentId()==id){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
            }
        }
        return studentList;
    }
    public JSONArray findStudentsByIdQuery(Integer id) {
        List<Student> students=studentRepository.findStudentById(id);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    //fetching all students
    public JSONArray findAllStudents() {
        List<Student> students=studentRepository.findAll();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
                JSONObject jsonObject=createResponse(student);
                studentList.put(jsonObject);
        }
        return studentList;
    }
    public JSONArray findAllStudentsByQuery() {
        List<Student> students=studentRepository.findAllbyQuery();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONObject createResponse (Student student){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("studentId",student.getStudentId());
        jsonObject.put("firstName",student.getFirstName());
        jsonObject.put("lastName",student.getLastName());

        jsonObject.put("age",student.getAge());
        jsonObject.put("active",student.getActive());
        jsonObject.put("admission_date",student.getAdmissionDate());
        return jsonObject;
    }


}
