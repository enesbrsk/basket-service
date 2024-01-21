package com.service.basket.dto.request;

import com.service.basket.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SignUpRequest {

    private String username;
    private String password;
    private Role role;
}