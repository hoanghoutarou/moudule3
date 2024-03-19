package com.ra.model.dto.request;

import com.ra.model.entity.Orders;
import com.ra.model.entity.User;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
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
public class OrderRequest {
    private String serialNumber;
    @NotNull(message = "Không đuược null")
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
}
