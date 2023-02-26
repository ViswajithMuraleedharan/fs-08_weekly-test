package com.example.PortalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_course")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;
    @Column(name = "title")
    private String title;
    @Column(name = "course_desc")
    private String desc;
    @Column(name = "course_duration")
    private String duration;

    @ManyToMany(fetch = FetchType.LAZY)
    List<Student> studentList = new ArrayList<>();
}
