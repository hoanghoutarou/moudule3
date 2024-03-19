package com.ra.model.dto.response;

import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderResponse {
    private Long orderId;
    private String serialNumber;
    private User user;
    private Double totalPrice;
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Date receiveAt;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    public enum StatusEnum {
        WAITING ,
        CONFIRM ,
        DELIVERY ,
        SUCCESS ,
        CANCEL ,
        DENIED
    }

    public OrderResponse(Orders orders) {
        this.orderId = orders.getOrderId();
        this.serialNumber = orders.getSerialNumber();
        this.user = orders.getUser();
        this.totalPrice = orders.getTotalPrice();
        this.note = orders.getNote();
        this.receiveName = orders.getReceiveName();
        this.receiveAddress = orders.getReceiveAddress();
        this.receivePhone = orders.getReceivePhone();
        this.createdAt = orders.getCreatedAt();
        this.receiveAt=orders.getReceiveAt();
    }
}
