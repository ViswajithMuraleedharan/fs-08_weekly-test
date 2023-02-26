package com.example.PortalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private Integer ID;
    @Column(name = "book_title")
    private String title;
    @Column(name = "book_author")
    private String author;
    @Column(name = "book_desc")
    private String desc;
    @Column(name = "book_price")
    private String price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
}
