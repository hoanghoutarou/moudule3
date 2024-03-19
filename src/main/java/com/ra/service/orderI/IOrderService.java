package com.ra.service.orderI;

import com.ra.model.dto.response.OrderResponse;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    Orders add(Address address, Double totalPrice);

    Page<OrderResponse> getAll(Pageable pageable);
    Orders save(Orders orders);
    Orders findById(Long id);
    Orders findBySerialNumber(String serialNumber);
    void delete(Long id);
}
