package com.service.englishdise.dto.request;

import com.service.englishdise.enums.Role;
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