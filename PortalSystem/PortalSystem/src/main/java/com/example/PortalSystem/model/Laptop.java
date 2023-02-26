package com.example.PortalSystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "tbl_laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "laptop_id")
    private Integer ID;
    @Column(name = "laptop_name")
    private String name;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private Integer price;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student_id;
}
