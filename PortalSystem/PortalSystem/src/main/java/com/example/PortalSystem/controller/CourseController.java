package com.example.PortalSystem.controller;

import com.example.PortalSystem.dao.CourseRepo;
import com.example.PortalSystem.dao.StudentRepo;
import com.example.PortalSystem.model.Course;
import com.example.PortalSystem.model.Student;
import com.example.PortalSystem.services.CourseService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;
    @Autowired
    CourseRepo courseRepo;
    @Autowired
    StudentRepo studentRepo;
    @PostMapping(value = "/course")
    public ResponseEntity addCourse(@RequestParam String courseResponse){
        JSONObject json = new JSONObject(courseResponse);
        Course course = new Course();
        course.setDesc(json.getString("description"));
        course.setTitle(json.getString("title"));
        course.setDuration(json.getString("duration"));

        List<Student> list=new ArrayList<>();
        String studentid = json.getString("student_id");
        Student student = studentRepo.findById(Integer.valueOf(studentid)).get();
        if(null != student){
            list.add(student);
        }
        course.setStudentList(list);
        Course cs = courseRepo.save(course);
        return new ResponseEntity<>(cs.toString(),HttpStatus.OK);
    }
    @GetMapping("/get-course")
    public List<Course> getAllCourse(){
        List<Course> list = courseService.getAllCourse();
        return list;
    }
    @DeleteMapping("/delete-course/{course_id}")
    public ResponseEntity deleteCourse(@PathVariable String course_id){
        courseService.deleteCourse(course_id);
        return new ResponseEntity<>("Course deleted successfully",HttpStatus.OK);
    }

    @PutMapping("/update-course/{courseid}")
    public ResponseEntity<String> updateCourse(@RequestBody String updatedCourse, @PathVariable String courseid){

        for (Course course : courseRepo.findAll()) {
            if(course.getID()==(Integer.valueOf(courseid))){
                JSONObject json = new JSONObject(updatedCourse);
                Course crs = new Course();
                crs.setDesc(json.getString("description"));
                crs.setTitle(json.getString("title"));
                crs.setDuration(json.getString("duration"));

                course.setDesc(crs.getDesc());
                course.setTitle(crs.getTitle());
                course.setDuration(crs.getDuration());
                Course cs = courseRepo.save(course);
                return new ResponseEntity<String>(cs.toString(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("Not found", HttpStatus.BAD_REQUEST);

    }
}
