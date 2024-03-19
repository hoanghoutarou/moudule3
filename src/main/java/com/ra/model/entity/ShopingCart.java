package com.ra.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ShopingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shopingCartId;
    private int orderQuantity;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
