package com.example.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SignInRequest;
import com.example.demo.dto.SignInResponse;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImp implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    // @Override
    // public JwtAuthenticationResponse signup(SignUpRequest request) {
    // var user =
    // User.builder().firstName(request.getFirstName()).lastName(request.getLastName())
    // .email(request.getEmail()).password(passwordEncoder.encode(request.getPassword()))
    // .role(Role.USER).build();
    // userRepository.save(user);
    // var jwt = jwtService.generateToken(user);
    // return JwtAuthenticationResponse.builder().token(jwt).build();
    // }

    @Override
    public SignInResponse signin(SignInRequest request) {

        var user = userRepository.findByUsernameOrEmail(request.getUsername(), request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        return SignInResponse.builder().user(user).jwt(jwt).build();
    }
}