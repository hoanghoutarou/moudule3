package com.ra.model.dto.request;

import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDetailRequest {
    private Product product;
    private Orders orders;
    private String productName;
    private Double unitPrice;
    @Min(1)
    private Integer orderQuantity;
}
