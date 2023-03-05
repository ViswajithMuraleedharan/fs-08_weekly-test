package com.example.CustomerQuery.controller;

import com.example.CustomerQuery.dao.IStudentRepository;
import com.example.CustomerQuery.model.Student;
import com.example.CustomerQuery.service.StudentService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class studentController {
    @Autowired
    StudentService studentService;
    @Autowired
    IStudentRepository studentRepository;
    @PostMapping("/create_student")
    public ResponseEntity<String> createStudent(@RequestBody String studentData){
        JSONObject errorList=isValidStudent(studentData);
        if(errorList.isEmpty()){
            Student student=setStudent(studentData);
            return new ResponseEntity<>("Student created at:- "+student.getStudentId(), HttpStatus.CREATED);
        }
        else return new ResponseEntity<>(errorList.toString(),HttpStatus.BAD_REQUEST);
    }

    private Student setStudent(String studentData) {
        JSONObject studentObj=new JSONObject(studentData);
        Student student=new Student();
        student.setFirstName(studentObj.getString("firstName"));
        student.setLastName(studentObj.getString("lastName"));
        student.setAge(studentObj.getInt("age"));
        student.setActive(true);
        Date date=new Date(System.currentTimeMillis());
        student.setAdmissionDate(date);

        Student student1=studentService.saveStudent(student);
        return student1;
    }

    private JSONObject isValidStudent(String studentData) {
        JSONObject studentObj=new JSONObject(studentData);
        JSONObject errorList=new JSONObject();
        if(!studentObj.has("firstName")){
            errorList.put("firstName","Missing parameter");
        }
        if(!studentObj.has("lastName")){
            errorList.put("lastName","Missing parameter");
        }
        if(!studentObj.has("age")){
            errorList.put("age","Missing parameter");
        }
        return errorList;
    }

    //fetching all students
    @GetMapping("/getallstudent")
    public ResponseEntity<String> findAllStudents(){
        JSONArray students=studentService.findAllStudents();
        return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getallStudentByQuery")
    public ResponseEntity<String> findAllStudentByQuery(){
        JSONArray students=studentService.findAllStudentsByQuery();
        return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }



    //fetching students using first name
    @GetMapping("/getstudentby_first_name")
    public ResponseEntity<String> findStudentByfirstName(@RequestParam String firstName){
         JSONArray students=studentService.findStudentByfirstName(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByFirstNameByQuery")
    public ResponseEntity<String> findStudentByFirstNameusingQuey(@RequestParam String firstName){
        JSONArray students=studentService.findStudentsByfirstNameQuery(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    //fetching students using last name
    @GetMapping("/getstudentby_last_name")
    public ResponseEntity<String> findStudentBylastName(@RequestParam String lastName){
        JSONArray students=studentService.findStudentBylastName(lastName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+lastName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByLastNameByQuery")
    public ResponseEntity<String> findStudentBylastNameusingQuey(@RequestParam String lastName){
        JSONArray students=studentService.findStudentsBylastNameQuery(lastName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+lastName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    //fetching students using age
    @GetMapping("/getstudentbyage")
    public ResponseEntity<String> findStudentByAge(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAge(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age "+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByAgeByQuery")
    public ResponseEntity<String> findStudentByAgeusingQuey(@RequestParam Integer age){
        JSONArray students=studentService.findStudentsByAgeQuery(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age "+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    //fetching students using active
    @GetMapping("/getstudentbyactive")
    public ResponseEntity<String> findStudentByActive(@RequestParam Boolean active){
        JSONArray students=studentService.findStudentByActive(active);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with active "+active+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByActiveByQuery")
    public ResponseEntity<String> findStudentByActiveusingQuey(@RequestParam Boolean active){
        JSONArray students=studentService.findStudentsByActiveQuery(active);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with active "+active+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    //fetching students using admission_date
    @GetMapping("/getstudentbyDate")
    public ResponseEntity<String> findStudentByActive(@RequestParam Date admission_date){
        JSONArray students=studentService.findStudentByDate(admission_date);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with date "+admission_date+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByDateByQuery")
    public ResponseEntity<String> findStudentByDateusingQuey(@RequestParam Date admission_date){
        JSONArray students=studentService.findStudentsByDateQuery(admission_date);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with admission_date "+admission_date+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    //fetching students using student_id
    @GetMapping("/getstudentbyid")
    public ResponseEntity<String> findStudentById(@RequestParam Integer student_id){
        JSONArray students=studentService.findStudentById(student_id);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with student_id "+student_id+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByIdByQuery")
    public ResponseEntity<String> findStudentByStudentIdusingQuey(@RequestParam Integer student_id){
        JSONArray students=studentService.findStudentsByIdQuery(student_id);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age "+student_id+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
}
