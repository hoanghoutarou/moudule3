package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String sku;
    @Column(unique = true,nullable = false)
    private String productName;
    private String description;
    private Double unitPrice;
    private Integer stockQuantity;
    private String image;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<WishList> wishLists;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}
