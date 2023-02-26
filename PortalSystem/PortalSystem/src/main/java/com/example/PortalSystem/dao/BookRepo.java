package com.example.PortalSystem.dao;

import com.example.PortalSystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Integer> {
}
