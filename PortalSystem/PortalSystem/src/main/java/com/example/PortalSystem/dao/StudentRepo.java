package com.example.PortalSystem.dao;

import com.example.PortalSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {
}
