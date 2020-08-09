package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.service.TokenService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TokenController {
    
    private final TokenService tokenService;

    @GetMapping("/total")
    public String token() throws Exception {
        return tokenService.totalSupply();
    }

    @GetMapping("/balance/{email}")
    public String getBalance(@PathVariable String email) throws Exception {
        
        return tokenService.getBalance(email);
    }
    
}