package com.ra.model.dto.response;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {
    private Long id;
    private String sku;
    private String productName;
    private String description;
    private Double unitPrice;
    private Integer stockQuantity;
    private String image;
    private Category category;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.sku=product.getSku();
        this.productName = product.getProductName();
        this.description=product.getDescription();
        this.unitPrice = product.getUnitPrice();
        this.stockQuantity=product.getStockQuantity();
        this.image = product.getImage();
        this.createdAt = product.getCreatedAt();
        this.updatedAt = product.getUpdatedAt();
        this.category = product.getCategory();

    }
}

