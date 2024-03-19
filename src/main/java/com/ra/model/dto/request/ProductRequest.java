package com.ra.model.dto.request;

import com.ra.model.entity.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
    private String sku;
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    private String productName;
    private String description;
    @Min(0)
    private Double unitPrice;
    private Integer stockQuantity;
    private String image;
    private Long categoryId;
}
