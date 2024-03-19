package com.ra.repository;

import com.ra.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByCategoryId(Long categoryId);
    @Query(value = "SELECT p.* FROM Product p WHERE p.productName LIKE CONCAT('%', ?1, '%') OR p.description LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<Product> findProductByProductNameOrDescription(String search);
}
