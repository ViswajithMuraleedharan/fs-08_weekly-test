package com.example.PortalSystem.dao;

import com.example.PortalSystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {
}
