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

    @GetMapping("/getStudentByFirstNameandLastName")
    public ResponseEntity<String> findStudentByfirstNameandlastName(@RequestParam String firstName,@RequestParam String lastName){
         JSONArray students=studentService.findStudentByfirstNameAndLastName(firstName,lastName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with firstName"+firstName+"and lastName"+lastName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentByFirstNameorLastName")
    public ResponseEntity<String> findStudentByfirstNameorlastName(@RequestParam String firstName,@RequestParam String lastName){
        JSONArray students=studentService.findStudentByfirstNameOrLastName(firstName,lastName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with firstName"+firstName+"or lastName"+lastName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByFirstName")
    public ResponseEntity<String> findStudentByfirstName(@RequestParam String firstName){
        JSONArray students=studentService.findStudentByfirstName(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByDate")
    public ResponseEntity<String> findStudentBydate(@RequestParam Date startDate,@RequestParam Date endDate){
        JSONArray students=studentService.findStudentByDate(startDate,endDate);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user btw "+startDate+" & " +endDate+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentByagelessthan")
    public ResponseEntity<String> findStudentByagelassthan(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAgelessthan(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age less than "+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentByagemorethan")
    public ResponseEntity<String> findStudentByagemorethan(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAgemorethan(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age more than "+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByagelessorequalsthan")
    public ResponseEntity<String> findStudentByagelessthanorequal(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAgelessthanorequal(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age less than or equals"+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentByagemoreorequalsthan")
    public ResponseEntity<String> findStudentByagemorethanorequal(@RequestParam Integer age){
        JSONArray students=studentService.findStudentByAgelmorethanorequal(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age more than or equals"+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentBydatemorethan")
    public ResponseEntity<String> findStudentBydatemorethan(@RequestParam Date date){
        JSONArray students=studentService.findStudentByDatemorethan(date);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with date more than "+date+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentBydatelessthan")
    public ResponseEntity<String> findStudentBydatelessthan(@RequestParam Date date){
        JSONArray students=studentService.findStudentByDatelessthan(date);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with date more than "+date+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwhoseageisnull")
    public ResponseEntity<String> findStudentwhoseageisnull(){
        JSONArray students=studentService.findStudentwhoseageisnull();
        if(students.isEmpty()){
            return new ResponseEntity<>("No such user exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwhoseageisnotnull")
    public ResponseEntity<String> findStudentwhoseageisnotnull(){
        JSONArray students=studentService.findStudentwhoseageisnotnull();
        if(students.isEmpty()){
            return new ResponseEntity<>("No such user exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentwhereFirstNamebelike")
    public ResponseEntity<String> findStudentwherefirstNamebeLike(@RequestParam String firstName){
        JSONArray students=studentService.findStudentByfirstNamebelike(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwhereFirstNamenotlike")
    public ResponseEntity<String> findStudentwherefirstNamenotLike(@RequestParam String firstName){
        JSONArray students=studentService.findStudentByfirstNamenotlike(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }

    @GetMapping("/getStudentwhereFirstNamestartswith")
    public ResponseEntity<String> findStudentwherefirstNamestarts(@RequestParam String firstName){
        JSONArray students=studentService.findStudentByfirststartswith(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwhereFirstNameendswith")
    public ResponseEntity<String> findStudentwherefirstNameends(@RequestParam String firstName){
        JSONArray students=studentService.findStudentByfirstendswith(firstName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with "+firstName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwhereFirstNamecontaining")
    public ResponseEntity<String> findStudentwherefirstNamecontaining(@RequestParam String name){
        JSONArray students=studentService.findStudentByfirstnamecontaining(name);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user containing "+name+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwhereFirstNamenotcontaining")
    public ResponseEntity<String> findStudentwherefirstNamenotcontaining(@RequestParam String name){
        JSONArray students=studentService.findStudentByfirstnamenotcontaining(name);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user containing "+name+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentwherelaststNamenot")
    public ResponseEntity<String> findStudentwherelastNamenot(@RequestParam String lastName){
        JSONArray students=studentService.findStudentBylastnamenotcontaining(lastName);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user containing "+lastName+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentbyagedesclastname")
    public ResponseEntity<String> findStudentbyagedesclastname(@RequestParam Integer age){
        JSONArray students=studentService.findStudentbyagedesclastname(age);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user with age"+age+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentbyagein")
    public ResponseEntity<String> findStudentbyagein(@RequestParam List<Integer> ages){
        JSONArray students=studentService.findStudentbyagein(ages);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user in age"+ages+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getStudentbyagenotin")
    public ResponseEntity<String> findStudentbyagenotin(@RequestParam List<Integer> ages){
        JSONArray students=studentService.findStudentbyagenotin(ages);
        if(students.isEmpty()){
            return new ResponseEntity<>("No user in age"+ages+" exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getactivestudent")
    public ResponseEntity<String> getactivestudent(){
        JSONArray students=studentService.getactivestudent();
        if(students.isEmpty()){
            return new ResponseEntity<>("No active students exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/getinactivestudent")
    public ResponseEntity<String> getinactivestudent(){
        JSONArray students=studentService.getinactivestudent();
        if(students.isEmpty()){
            return new ResponseEntity<>("No inactive students exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
    @GetMapping("/studentignorecase")
    public ResponseEntity<String> studentignorecase(@RequestParam String name){
        JSONArray students=studentService.studentignorecase(name);
        if(students.isEmpty()){
            return new ResponseEntity<>("No such students exists",HttpStatus.BAD_REQUEST);
        }
        else return new ResponseEntity<>(students.toString(),HttpStatus.OK);
    }
}
