package com.blockchain.armagyeddon.controller;

import java.io.IOException;

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

    @GetMapping("/charge/{email}/{amount}")
    public String chargeToken(@PathVariable String email, 
        @PathVariable String amount) throws IOException {

        return tokenService.chargeToken(email, amount);
    }
    
}