package com.ra.model.dto.response;

import com.ra.model.entity.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserResponse {
    private Long id;
    private String fullName;
    private String userName;
    private String password;
    private Boolean status;
    private String email;
    private String phone;
    private String address;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public UserResponse(User user) {
        this.id = user.getId();
        this.fullName = user.getFullName();
        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.status = user.getStatus();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
