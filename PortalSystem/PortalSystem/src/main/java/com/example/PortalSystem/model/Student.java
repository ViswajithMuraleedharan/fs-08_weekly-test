package com.example.PortalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_student")
public class Student {
    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer Id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private String age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "branch")
    private String branch;
    @Column(name = "department")
    private String dept;

    @Embedded
    private Address address;
}
