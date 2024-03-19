package com.ra.model.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserLogin {
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    @Size // dùng cho chuỗi
    @Length // dùng cho chuỗi
    @Min(0L) // dùng cho số
    @Max(0L) // dùng cho số
    @Pattern(regexp = "") // dùng pattern để validate
    private String userName;
    @NotNull(message = "Không đuược null")
    @NotEmpty(message = "Không được rỗng")
    @NotBlank(message = "Không được để trống")
    private String password;

}
