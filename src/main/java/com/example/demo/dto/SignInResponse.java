package com.example.demo.dto;

import com.example.demo.model.User;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SignInResponse {
    private final User user;
    private final String jwt;
}
