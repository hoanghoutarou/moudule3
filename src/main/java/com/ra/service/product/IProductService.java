package com.ra.service.product;

import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Product;
import com.ra.model.entity.ShopingCart;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<ProductResponse> getAll(Pageable pageable);
    Product save(Product product);
    Product findById(Long id);
    List<Product> findByCategoryId(Long categoryId);
    List<Product> findAllByProductNameOrDescription(String search);

    void delete(Long id);

}
