
package com.example.securityjwt.controller;

import com.example.securityjwt.security.JWTUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/init")
    public Map<String, String> login(@RequestBody AuthDto appUser) {
        UsernamePasswordAuthenticationToken authInput =
                new UsernamePasswordAuthenticationToken(appUser.getUsername(),
                        appUser.getPassword());
        authenticationManager.authenticate(authInput);
        String token = jwtUtil.generateToken(appUser.getUsername());
        return Map.of("jwt-token", token);
    }
}
