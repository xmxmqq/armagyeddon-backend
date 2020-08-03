package com.blockchain.armagyeddon.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
    
    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUp(){
        return "sign-up";
    }
    
    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/testform")
    public String testform(){
        return "testform";
    }

    @GetMapping("/gyefinder")
    public String gyefinder(){
        return "gyefinder";
    }

    @GetMapping("/gyecreation")
    public String gyecreation(){
        return "gyecreation";
    }

    @GetMapping("/gyejoining")
    public String gyejoining(){
        return "gyejoining";
    }


    @GetMapping("/token")
    public String toekn(){
        return "token/token";
    }

    @GetMapping("token/charge")
    public String charge(){
        return "token/charge";
    }




}