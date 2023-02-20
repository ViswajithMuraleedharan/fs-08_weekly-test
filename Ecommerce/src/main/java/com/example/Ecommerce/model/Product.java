package com.example.Ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_Product")
public class Product {
    @Id
    @Column(name = "prodId")
    private Integer prod_id;
    @Column(name="prodName")
    private String prod_name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "desc")
    private String desc;
    @Column(name = "category")
    private String category;

    @Column(name = "brand")
    private String brand;
}
