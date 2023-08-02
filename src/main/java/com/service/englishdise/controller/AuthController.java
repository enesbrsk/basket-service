package com.service.englishdise.controller;

import com.service.englishdise.dto.TokenResponseDto;
import com.service.englishdise.dto.request.LoginRequest;
import com.service.englishdise.dto.request.SignUpRequest;
import com.service.englishdise.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> authenticate(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authService.signup(signUpRequest));
    }
}