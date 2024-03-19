package com.ra.model.dto.response;

import com.ra.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class CategoryResponse {
    private Long id;
    private String categoryName,description;
    private Boolean status ;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.categoryName = category.getCategoryName();
        this.description=category.getDescription();
    }
}
