package com.ra.service.category;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.repository.ICategoryRepository;
import com.ra.repository.IProductRepository;
import com.ra.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<CategoryResponse> getAll(Pageable pageable) {
        //mapper
        Page<Category> categories = categoryRepository.findAll(pageable);
        return categories.map(CategoryResponse::new);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean delete(Long id) {
        if (productRepository.findAllByCategoryId(id).isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
