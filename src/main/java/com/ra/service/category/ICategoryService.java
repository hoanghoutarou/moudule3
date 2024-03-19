package com.ra.service.category;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryResponse> getAll(Pageable pageable);
    Category save(Category category);
    Category findById(Long id);
    boolean delete(Long id);
}
