package com.example.PortalSystem.dao;

import com.example.PortalSystem.model.Course;
import com.example.PortalSystem.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,Integer> {
}
