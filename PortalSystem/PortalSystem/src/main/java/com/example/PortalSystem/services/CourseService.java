package com.example.PortalSystem.services;

import com.example.PortalSystem.dao.CourseRepo;
import com.example.PortalSystem.model.Course;
import com.example.PortalSystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;
    public void addCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getAllCourse() {
        return courseRepo.findAll();
    }

    public ResponseEntity deleteCourse(String courseId) {
        for (Course course : courseRepo.findAll()) {
            if (course.getID()==(Integer.valueOf(courseId))){
                courseRepo.delete(course);
                return new ResponseEntity<>("course deleted successfully", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("deleted failed, courseId not found",HttpStatus.BAD_REQUEST);
    }

}
