package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_Address")
public class Address {
    @Id
    @Column(name = "addrId")
    private Integer addr_id;
    @Column(name="addrName")
    private String addr_name;
    @Column(name = "landmark")
    private String landmark;
    @Column(name = "phone_num")
    private String phone;
    @Column(name = "zipcode")
    private String zipcode;

    @Column(name = "state")
    private String state;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;
}
