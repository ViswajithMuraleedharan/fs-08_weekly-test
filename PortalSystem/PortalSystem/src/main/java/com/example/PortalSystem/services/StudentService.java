package com.example.PortalSystem.services;

import com.example.PortalSystem.dao.StudentRepo;
import com.example.PortalSystem.model.Student;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepo studentRepo;
    public int saveStudent(Student student){
       Student student1= studentRepo.save(student);
       return student1.getId();
    }

    public JSONArray getUser(String studentId) {
        JSONArray studentArray=new JSONArray();
        if(studentId!=null && studentRepo.findById(Integer.valueOf(studentId)).isPresent()){
            Student student=studentRepo.findById(Integer.valueOf(studentId)).get();
            JSONObject jsonObject=setStudent(student);
            studentArray.put(jsonObject);
        }
        else{
            List<Student> studentList=studentRepo.findAll();
            for(Student student:studentList){
                JSONObject jsonObject=setStudent(student);
                studentArray.put(jsonObject);
            }
        }
        return studentArray;
    }

    private JSONObject setStudent(Student student) {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("id",student.getId());
        jsonObject.put("name",student.getName());
        jsonObject.put("age",student.getAge());
        jsonObject.put("phoneNumber",student.getPhoneNumber());
        jsonObject.put("branch",student.getBranch());
        jsonObject.put("dept",student.getDept());
        jsonObject.put("address",student.getAddress());
        return jsonObject;
    }

    public void updateStudent(String studentId, Student newstudent) {
        if(studentId!=null && studentRepo.findById(Integer.valueOf(studentId)).isPresent()){
            Student student=studentRepo.findById(Integer.valueOf(studentId)).get();
            newstudent.setId(student.getId());
            newstudent.setAddress(student.getAddress());
            studentRepo.save(student);
        }
    }

    public void deleteStudent(String studentId) {
        if(studentId!=null && studentRepo.findById(Integer.valueOf(studentId)).isPresent()){
            studentRepo.deleteById(Integer.valueOf(studentId));
        }
    }
}
