package com.ra.controller.admin;

import com.ra.model.dto.request.CategoryRequest;
import com.ra.model.dto.request.ProductRequest;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.service.category.ICategoryService;
import com.ra.service.product.IProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/admin/products")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "productName",name = "sort") String sort,
            @RequestParam(defaultValue = "desc",name = "order") String order
    ){
        Pageable pageable ;
        if(order.equals("asc")){
            pageable = PageRequest.of(page,limit, Sort.by(sort).ascending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        }
        Page<ProductResponse> products = productService.getAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @Transactional
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody @Valid ProductRequest productRequest) {
        if (categoryService.findById(productRequest.getCategoryId()) == null) {
            return new ResponseEntity<>("Khong ton tai Category", HttpStatus.BAD_REQUEST);
        }
        Product product = new Product();
        UUID uuid=UUID.randomUUID();
        LocalDateTime now = LocalDateTime.now();
        String random = String.valueOf(uuid);
        product.setSku(random);
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setImage(productRequest.getImage());
        product.setCategory(categoryService.findById(productRequest.getCategoryId()));
        product.setCreatedAt(now);
        product.setUpdatedAt(now);
        Product productNew = productService.save(product);
        return new ResponseEntity<>(productNew, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Product productUpdate = productService.findById(id);
        return new ResponseEntity<>(productUpdate, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid ProductRequest productRequest ,@PathVariable Long id) {
        Product product = productService.findById(id);
        LocalDateTime now = LocalDateTime.now();
        product.setId(id);
        product.setSku(productRequest.getSku());
        product.setProductName(productRequest.getProductName());
        product.setDescription(productRequest.getDescription());
        product.setUnitPrice(productRequest.getUnitPrice());
        product.setStockQuantity(productRequest.getStockQuantity());
        product.setImage(productRequest.getImage());
        product.setCategory(categoryService.findById(productRequest.getCategoryId()));
        product.setUpdatedAt(now);
        Product productUpdate = productService.save(product);
        return new ResponseEntity<>(productUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity<>("Đã xóa", HttpStatus.NO_CONTENT);
    }
}
