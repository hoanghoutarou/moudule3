package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String serialNumber;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private Double totalPrice;
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
    private String note;
    private String receiveName;
    private String receiveAddress;
    private String receivePhone;
    private LocalDateTime createdAt = LocalDateTime.now();
    private Date receiveAt;
    @OneToMany(mappedBy = "orders")
    @JsonIgnore
    private List<OrderDetail> orderDetails;
}
