package com.example.securityjwt.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AuthDto {
    String username;
    String password;
}
