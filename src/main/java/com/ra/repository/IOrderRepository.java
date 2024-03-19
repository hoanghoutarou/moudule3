package com.ra.repository;

import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IOrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> findBySerialNumberIgnoreCase(String serialNumber);


}
