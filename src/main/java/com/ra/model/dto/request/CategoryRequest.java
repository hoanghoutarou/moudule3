package com.ra.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryRequest {
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    private String categoryName;
    private String description;
    private Boolean status;
}
