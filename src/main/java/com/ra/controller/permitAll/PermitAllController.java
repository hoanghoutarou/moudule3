package com.ra.controller.permitAll;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Product;
import com.ra.model.entity.User;
import com.ra.service.category.ICategoryService;
import com.ra.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class PermitAllController {
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategory(
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
    @GetMapping("/product")
    public ResponseEntity<?> getAllProduct(
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
    @GetMapping("/product/new-products")
    public ResponseEntity<?> getNew(
            @RequestParam(defaultValue = "5",name = "limit") int limit,
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "id",name = "sort") String sort
    ){
        Pageable pageable = PageRequest.of(page,limit, Sort.by(sort).descending());
        Page<ProductResponse> products = productService.getAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/product/categories/{catalogId}")
    public ResponseEntity<?> getProductByCategoryId(@PathVariable Long catalogId) {
        List<Product> products = productService.findByCategoryId(catalogId);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id) {
        Product productUpdate = productService.findById(id);
        return new ResponseEntity<>(productUpdate, HttpStatus.OK);
    }
    @GetMapping("/product/search/{search}")
    public ResponseEntity<?> findProductByNameOrDescription(@PathVariable String search) {
        List<Product> products = productService.findAllByProductNameOrDescription(search);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
