package com.example.Ecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_Order")
public class Order {
    @Id
    @Column(name = "orderId")
    private Integer order_id;

    @JoinColumn(name="userId")
    @ManyToOne
    private User user_id;

    @JoinColumn(name="prodId")
    @ManyToOne
    private Product prod_id;

    @JoinColumn(name="addrId")
    @ManyToOne
    private Address addr_id;

    @Column(name = "quantity")
    private Integer quantity;

}
