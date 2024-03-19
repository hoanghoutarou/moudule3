package com.ra.service.orderI;

import com.ra.model.entity.OrderDetail;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import com.ra.repository.IOrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public class OrderDetailServiceImpl  {
//    @Autowired
//    private IOrderDetailRepository orderDetailRepository;
//    @Override
//    public List<OrderDetail> getByOrderId(Long orderId) {
//        return orderDetailRepository.findByOrderId(orderId);
//    }
//
//    @Override
//    public OrderDetail add(Product product, Orders orders, int orderQuantity) {
//        OrderDetail orderDetail = OrderDetail.builder()
//                .orders(orders)
//                .product(product)
//                .productName(product.getProductName())
//                .unitPrice(product.getUnitPrice())
//                .orderQuantity(orderQuantity)
//                .build();
//        return orderDetailRepository.save(orderDetail);
//    }
}
