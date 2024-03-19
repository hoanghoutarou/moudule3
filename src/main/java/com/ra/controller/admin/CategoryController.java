package com.ra.controller.admin;

import com.ra.model.dto.request.CategoryRequest;
import com.ra.model.dto.request.UserRegister;
import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.entity.Category;
import com.ra.service.category.ICategoryService;
import com.ra.service.product.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/admin/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5", name = "limit") int limit,
            @RequestParam(defaultValue = "0", name = "page") int page,
            @RequestParam(defaultValue = "categoryName", name = "sort") String sort,
            @RequestParam(defaultValue = "asc", name = "order") String order
    ) {
        Pageable pageable;
        if (order.equals("asc")) {
            pageable = PageRequest.of(page, limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page, limit, Sort.by(sort).descending());
        }
        Page<CategoryResponse> categories = categoryService.getAll(pageable);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setDescription(categoryRequest.getDescription());
        category.setStatus(true);
        Category categoryNew = categoryService.save(category);
        return new ResponseEntity<>(categoryNew, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Category categoryUpdate = categoryService.findById(id);
        if(categoryUpdate == null) {
            return new ResponseEntity<>("danh mực không tồn tại!", HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(categoryUpdate, HttpStatus.OK);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid CategoryRequest categoryRequest ,@PathVariable Long id) {
        Category category = new Category();
        category.setId(id);
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setStatus(categoryRequest.getStatus());
        category.setDescription(categoryRequest.getDescription());
        Category categoryUpdate = categoryService.save(category);
        return new ResponseEntity<>(categoryUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (categoryService.delete(id)==true){
            categoryService.delete(id);
            return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>("Khong xoa duoc",HttpStatus.BAD_REQUEST);
        }
    }
}
