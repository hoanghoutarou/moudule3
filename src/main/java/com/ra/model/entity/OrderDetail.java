package com.ra.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Orders orders;
    private String productName;
    private Double unitPrice;
    private Integer orderQuantity;
}
