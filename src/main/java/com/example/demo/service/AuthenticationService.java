package com.example.demo.service;

import com.example.demo.dto.SignInRequest;
import com.example.demo.dto.SignInResponse;

public interface AuthenticationService {
    // JwtAuthenticationResponse signup(SignUpRequest request);

    SignInResponse signin(SignInRequest request);
}