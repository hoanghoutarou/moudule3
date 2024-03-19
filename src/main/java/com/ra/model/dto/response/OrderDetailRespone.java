package com.ra.model.dto.response;

import com.ra.model.entity.OrderDetail;
import com.ra.model.entity.Orders;
import com.ra.model.entity.Product;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDetailRespone {
    private Product product;
    private Orders orders;
    private String productName;
    private Double unitPrice;
    private Integer orderQuantity;

    public OrderDetailRespone(OrderDetail orderDetail) {
        this.product = orderDetail.getProduct();
        this.orders = orderDetail.getOrders();
        this.productName = orderDetail.getProductName();
        this.unitPrice = orderDetail.getUnitPrice();
        this.orderQuantity = orderDetail.getOrderQuantity();
    }
}
