package com.example.PortalSystem.controller;

import com.example.PortalSystem.model.Student;
import com.example.PortalSystem.services.StudentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/student")
    public ResponseEntity<String> addStudent(@RequestBody String StudentResponse){
        Student student=setStudent(StudentResponse);
        int studentId=studentService.saveStudent(student);
        return new ResponseEntity<>("Student added successfully at id:-"+studentId, HttpStatus.CREATED);
    }
    @GetMapping(value = "/student")
    public ResponseEntity getStudent(@Nullable @RequestParam String studentId){
        JSONArray studentArray=studentService.getUser(studentId);
        return new ResponseEntity<>(studentArray.toString(),HttpStatus.OK);
    }
    @PutMapping("/student/{studentId}")
    public ResponseEntity updateStudent(@PathVariable String studentId,@RequestBody String studentRequest){
        Student student=setStudent(studentRequest);
        studentService.updateStudent(studentId,student);
        return new ResponseEntity<>("student updated",HttpStatus.OK);
    }
    @DeleteMapping("/student")
    public ResponseEntity deleteStudent(@RequestParam String studentId){
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>("Student deleted",HttpStatus.OK);
    }

    private Student setStudent(String studentResponse) {
        JSONObject jsonObject=new JSONObject(studentResponse);
        Student student=new Student();
        student.setName(jsonObject.getString("name"));
        student.setAge(jsonObject.getString("age"));
        student.setPhoneNumber(jsonObject.getString("phoneNumber"));
        student.setBranch(jsonObject.getString("branch"));
        student.setDept(jsonObject.getString("dept"));
        return student;
    }
}
