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

    public JSONArray findStudentByfirstNameAndLastName(String firstName, String lastName) {
        List<Student> students=studentRepository.findStudentByfirstNameandLastName(firstName,lastName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }
    public JSONArray findStudentByfirstNameOrLastName(String firstName, String lastName) {
        List<Student> students=studentRepository.findStudentByfirstNameOrLastName(firstName,lastName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstName(String firstName) {
        List<Student> students=studentRepository.findStudentByfirstName(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByDate(Date startDate, Date endDate) {
        List<Student> students=studentRepository.findStudentByDate(startDate,endDate);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByAgelessthan(Integer age) {
        List<Student> students=studentRepository.findStudentByAgelessthan(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByAgemorethan(Integer age) {
        List<Student> students=studentRepository.findStudentByAgemorethan(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByAgelessthanorequal(Integer age) {
        List<Student> students=studentRepository.findStudentByAgelessthanorequals(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByAgelmorethanorequal(Integer age) {
        List<Student> students=studentRepository.findStudentByAgemorethanorequals(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByDatemorethan(Date date) {
        List<Student> students=studentRepository.findStudentByDatemorethan(date);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByDatelessthan(Date date) {
        List<Student> students=studentRepository.findStudentByDatelessthan(date);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentwhoseageisnull() {
        List<Student> students=studentRepository.findStudentwhoseageisnull();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentwhoseageisnotnull() {
        List<Student> students=studentRepository.findStudentwhoseageisnotnull();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstNamebelike(String firstName) {
        List<Student> students=studentRepository.findStudentwherefirstNamebelike(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstNamenotlike(String firstName) {
        List<Student> students=studentRepository.findStudentwherefirstNamenotlike(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirststartswith(String firstName) {
        List<Student> students=studentRepository.findStudentwherefirstNamestartswith(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstendswith(String firstName) {
        List<Student> students=studentRepository.findStudentwherefirstNameendswith(firstName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstnamecontaining(String name) {
        List<Student> students=studentRepository.findStudentByfirstnamecontaining(name);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentByfirstnamenotcontaining(String name) {
        List<Student> students=studentRepository.findStudentByfirstnamenotcontaining(name);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentBylastnamenotcontaining(String lastName) {
        List<Student> students=studentRepository.findStudentBylastnamenot(lastName);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentbyagedesclastname(Integer age) {
        List<Student> students=studentRepository.findStudentbyagedesclastname(age);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentbyagein(List<Integer> ages) {
        List<Student> students=studentRepository.findStudentbyagein(ages);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray findStudentbyagenotin(List<Integer> ages) {
        List<Student> students=studentRepository.findStudentbyagenotin(ages);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray getactivestudent() {
        List<Student> students=studentRepository.getactivestudent();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray getinactivestudent() {
        List<Student> students=studentRepository.getinactivestudent();
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }

    public JSONArray studentignorecase(String name) {
        List<Student> students=studentRepository.studentignorecase(name);
        JSONArray studentList=new JSONArray();
        for(Student student:students){
            JSONObject jsonObject=createResponse(student);
            studentList.put(jsonObject);
        }
        return studentList;
    }
}
