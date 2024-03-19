package com.ra.model.dto.request;

import com.ra.model.entity.Product;
import com.ra.model.entity.User;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ShopingCartRequest {
    private Long shopingCartId;
    @Min(1)
    private int orderQuantity;
    private User user;
    private Product product;
}
