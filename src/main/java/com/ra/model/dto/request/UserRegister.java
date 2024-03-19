package com.ra.model.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserRegister {
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    private String fullName;
    @Length(min = 6,max = 100)
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    private String userName;
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    private String password;

    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "không đúng định dạng")
    private String email;

    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b",message = "không đúng định dạng")
    @Column(unique = true)
    private String phone;
    @NotEmpty(message = "Không được rỗng")
    private String address;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
    private Boolean status ;
}
