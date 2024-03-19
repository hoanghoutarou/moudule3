package com.ra.service.orderI;

import com.ra.model.dto.response.OrderResponse;
import com.ra.model.dto.response.ProductResponse;
import com.ra.model.entity.Address;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import com.ra.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{
    @Autowired
    IOrderRepository orderRepository;

    @Override
    public Orders add(Address address, Double totalPrice) {
        Orders order = Orders.builder()
                .user(address.getUser())
                .totalPrice(totalPrice)
                .status(Orders.StatusEnum.WAITING)
                .receiveName(address.getReceiveName())
                .receiveAddress(address.getFullAddress())
                .receivePhone(address.getPhone())
                .build();
        return orderRepository.save(order);
    }

    @Override
    public Page<OrderResponse> getAll(Pageable pageable) {
        Page<Orders> orders = orderRepository.findAll(pageable);
        return orders.map(OrderResponse::new);
    }

    @Override
    public Orders save(Orders orders) {
        return orderRepository.save(orders);
    }

    @Override
    public Orders findById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Orders findBySerialNumber(String serialNumber) {
        return (Orders) orderRepository.findBySerialNumberIgnoreCase(serialNumber);
//        return null;
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
