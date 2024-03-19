package com.ra.service.product;

import com.ra.model.dto.response.CategoryResponse;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.model.entity.ShopingCart;
import com.ra.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Page<ProductResponse> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(ProductResponse::new);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }



    @Override
    public  List<Product> findByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    public List<Product> findAllByProductNameOrDescription(String search) {
        return productRepository.findProductByProductNameOrDescription(search);
    }


    @Override
    public void delete(Long id) {
         productRepository.deleteById(id);
    }


}
