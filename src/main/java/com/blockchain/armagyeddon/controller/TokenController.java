package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.service.TokenService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TokenController {
    
    private final TokenService tokenService;

    @GetMapping("/token")
    public String token() throws Exception {
        return tokenService.totalSupply();
    }
    
}