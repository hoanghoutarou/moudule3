package com.ra.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class JwtResponse {
    private Long id;
    private String username;
    private String fullName;
    private String email;
    private String token;
    private final String type = "Bearer Token";
    private Set<String> roles;
}
